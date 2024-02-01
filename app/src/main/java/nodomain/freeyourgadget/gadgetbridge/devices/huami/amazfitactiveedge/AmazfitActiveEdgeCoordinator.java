/*  Copyright (C) 2023-2024 José Rebelo

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
package nodomain.freeyourgadget.gadgetbridge.devices.huami.amazfitactiveedge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import nodomain.freeyourgadget.gadgetbridge.R;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.zeppos.ZeppOsCoordinator;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDevice;

public class AmazfitActiveEdgeCoordinator extends ZeppOsCoordinator {
    @Override
    public boolean isExperimental() {
        return true;
    }

    @Override
    public String getDeviceBluetoothName() {
        return HuamiConst.AMAZFIT_ACTIVE_EDGE_NAME;
    }

    @Override
    public Set<Integer> getDeviceSources() {
        return new HashSet<>(Arrays.asList(8388864, 8388865));
    }

    @Override
    public int getDeviceNameResource() {
        return R.string.devicetype_amazfit_active_edge;
    }

    @Override
    protected Pattern getSupportedDeviceName() {
        return Pattern.compile(HuamiConst.AMAZFIT_ACTIVE_EDGE_NAME + ".*");
    }

    @Override
    public boolean supportsContinuousFindDevice() {
        return true;
    }

    @Override
    public boolean mainMenuHasMoreSection() {
        return true;
    }

    @Override
    public boolean supportsGpxUploads() {
        return true;
    }

    @Override
    public boolean supportsControlCenter() {
        return true;
    }

    @Override
    public boolean supportsToDoList() {
        return true;
    }

    @Override
    public boolean supportsWifiHotspot(final GBDevice device) {
        return true;
    }

    @Override
    public boolean supportsFtpServer(final GBDevice device) {
        return true;
    }

    public boolean supportsBluetoothPhoneCalls(final GBDevice device) {
        return true;
    }
}
