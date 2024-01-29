/*  Copyright (C) 2024 Damien Gaignon, Martin.JM

    This file is part of Gadgetbridge.

    Gadgetbridge is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Gadgetbridge is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>. */
package nodomain.freeyourgadget.gadgetbridge.service.devices.huawei.requests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import nodomain.freeyourgadget.gadgetbridge.devices.huawei.HuaweiCrypto;
import nodomain.freeyourgadget.gadgetbridge.devices.huawei.HuaweiPacket;
import nodomain.freeyourgadget.gadgetbridge.devices.huawei.packets.DeviceConfig;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huawei.HuaweiSupportProvider;
import nodomain.freeyourgadget.gadgetbridge.util.StringUtils;

public class GetAuthRequest extends Request {
    private static final Logger LOG = LoggerFactory.getLogger(GetAuthRequest.class);

    protected final byte[] clientNonce;
    protected short authVersion;
    protected boolean isHiChainLite = false;
    protected byte[] doubleNonce;
    protected byte[] key = null;

    public GetAuthRequest(HuaweiSupportProvider support,
            Request linkParamsReq) {
        super(support);
        this.serviceId = DeviceConfig.id;
        this.commandId = DeviceConfig.Auth.id;
        this.clientNonce = HuaweiCrypto.generateNonce();
        doubleNonce = ByteBuffer.allocate(32)
                .put(((GetLinkParamsRequest)linkParamsReq).serverNonce)
                .put(clientNonce)
                .array();
        this.authVersion = paramsProvider.getAuthVersion();
    }

    public GetAuthRequest(HuaweiSupportProvider support,
                          Request linkParamsReq,
                          boolean isHiChainLite) {
        this(support, linkParamsReq);
        this.isHiChainLite = isHiChainLite;
    }

    @Override
    protected List<byte[]> createRequest() throws RequestCreationException {
        huaweiCrypto = new HuaweiCrypto(authVersion, isHiChainLite);
        byte[] nonce;

        try {
            if (isHiChainLite) {
                key = paramsProvider.getPinCode();
                if (authVersion == 0x02)
                    key = paramsProvider.getSecretKey();
            }
            nonce = ByteBuffer.allocate(18)
                    .putShort(authVersion)
                    .put(clientNonce)
                    .array();
            byte[] challenge = huaweiCrypto.digestChallenge(key, doubleNonce);
            if (challenge == null)
                throw new RequestCreationException("Challenge null");
            return new DeviceConfig.Auth.Request(paramsProvider, challenge, nonce, isHiChainLite).serialize();
        } catch (HuaweiPacket.CryptoException e) {
            throw new RequestCreationException(e);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RequestCreationException("Digest exception", e);
        }
    }

    @Override
    protected void processResponse() throws ResponseParseException {
        LOG.debug("handle Auth");

        if (!(receivedPacket instanceof DeviceConfig.Auth.Response))
            throw new ResponseTypeMismatchException(receivedPacket, DeviceConfig.Auth.Response.class);

        try {
            byte[] expectedAnswer = huaweiCrypto.digestResponse(key, doubleNonce);
            if (expectedAnswer == null)
                throw new ResponseParseException("Challenge null");
            byte[] actualAnswer = ((DeviceConfig.Auth.Response) receivedPacket).challengeResponse;
            if (!Arrays.equals(expectedAnswer, actualAnswer)) {
                throw new ResponseParseException("Challenge answer mismatch : "
                        + StringUtils.bytesToHex(actualAnswer)
                        + " != "
                        + StringUtils.bytesToHex(expectedAnswer)
                );
            }
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new ResponseParseException("Challenge response digest exception");
        }
    }
}
