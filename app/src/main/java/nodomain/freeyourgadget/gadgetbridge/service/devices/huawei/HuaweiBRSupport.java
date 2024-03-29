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
package nodomain.freeyourgadget.gadgetbridge.service.devices.huawei;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;

import nodomain.freeyourgadget.gadgetbridge.devices.huawei.HuaweiConstants;
import nodomain.freeyourgadget.gadgetbridge.model.CallSpec;
import nodomain.freeyourgadget.gadgetbridge.model.MusicSpec;
import nodomain.freeyourgadget.gadgetbridge.model.MusicStateSpec;
import nodomain.freeyourgadget.gadgetbridge.model.NotificationSpec;
import nodomain.freeyourgadget.gadgetbridge.model.WeatherSpec;
import nodomain.freeyourgadget.gadgetbridge.service.btbr.AbstractBTBRDeviceSupport;
import nodomain.freeyourgadget.gadgetbridge.service.btbr.TransactionBuilder;

public class HuaweiBRSupport extends AbstractBTBRDeviceSupport {
    private static final Logger LOG = LoggerFactory.getLogger(HuaweiBRSupport.class);

    private final HuaweiSupportProvider supportProvider;

    public HuaweiBRSupport() {
        super(LOG);
        addSupportedService(HuaweiConstants.UUID_SERVICE_HUAWEI_SDP);
        setBufferSize(1032);
        supportProvider = new HuaweiSupportProvider(this);

    }

    @Override
    protected TransactionBuilder initializeDevice(TransactionBuilder builder) {
        return supportProvider.initializeDevice(builder);
    }

    @Override
    public boolean connectFirstTime() {
        supportProvider.setNeedsAuth(true);
        return connect();
    }

    @Override
    public void onSocketRead(byte[] data) {
        supportProvider.onSocketRead(data);
    }

    @Override
    public boolean useAutoConnect() {
        return true;
    }

    @Override
    public void onSendConfiguration(String config) {
        supportProvider.onSendConfiguration(config);
    }

    @Override
    public void onFetchRecordedData(int dataTypes) {
        supportProvider.onFetchRecordedData(dataTypes);
    }

    @Override
    public void onReset(int flags) {
        supportProvider.onReset(flags);
    }

    @Override
    public void onNotification(NotificationSpec notificationSpec) {
        supportProvider.onNotification(notificationSpec);
    }

    @Override
    public void onSetTime() {
        supportProvider.onSetTime();
    }

    @Override
    public void onSetAlarms(ArrayList<? extends nodomain.freeyourgadget.gadgetbridge.model.Alarm> alarms) {
        supportProvider.onSetAlarms(alarms);
    }

    @Override
    public void onSetCallState(CallSpec callSpec) {
        supportProvider.onSetCallState(callSpec);
    }

    @Override
    public void onSetMusicState(MusicStateSpec stateSpec) {
        supportProvider.onSetMusicState(stateSpec);
    }

    @Override
    public void onSetMusicInfo(MusicSpec musicSpec) {
        supportProvider.onSetMusicInfo(musicSpec);
    }

    @Override
    public void onSetPhoneVolume(float volume) {
        supportProvider.onSetPhoneVolume();
    }

    @Override
    public void onFindPhone(boolean start) {
        if (!start)
            supportProvider.onStopFindPhone();
    }

    @Override
    public void onSendWeather(ArrayList<WeatherSpec> weatherSpecs) {
        supportProvider.onSendWeather(weatherSpecs);
    }
}
