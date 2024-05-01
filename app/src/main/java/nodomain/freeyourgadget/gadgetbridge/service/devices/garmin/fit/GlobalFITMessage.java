package nodomain.freeyourgadget.gadgetbridge.service.devices.garmin.fit;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nodomain.freeyourgadget.gadgetbridge.service.devices.garmin.fit.baseTypes.BaseType;

public class GlobalFITMessage {
    public static GlobalFITMessage FILE_ID = new GlobalFITMessage(0, "FILE_ID", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.ENUM, "type", FieldDefinitionFactory.FIELD.FILE_TYPE),
            new FieldDefinitionPrimitive(1, BaseType.UINT16, "manufacturer"),
            new FieldDefinitionPrimitive(2, BaseType.UINT16, "product"),
            new FieldDefinitionPrimitive(3, BaseType.UINT32Z, "serial_number"),
            new FieldDefinitionPrimitive(4, BaseType.UINT32, "time_created", FieldDefinitionFactory.FIELD.TIMESTAMP),
            new FieldDefinitionPrimitive(5, BaseType.UINT16, "number"),
            new FieldDefinitionPrimitive(6, BaseType.UINT16, "manufacturer_partner"),
            new FieldDefinitionPrimitive(8, BaseType.STRING, 20, "product_name")
    ));

    public static GlobalFITMessage DEVICE_SETTINGS = new GlobalFITMessage(2, "DEVICE_SETTINGS", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.UINT8, "active_time_zone"),
            new FieldDefinitionPrimitive(1, BaseType.UINT32, "utc_offset"),
            new FieldDefinitionPrimitive(2, BaseType.UINT32, "time_offset"),
            new FieldDefinitionPrimitive(4, BaseType.ENUM, "time_mode"),
            new FieldDefinitionPrimitive(5, BaseType.SINT8, "time_zone_offset"),
            new FieldDefinitionPrimitive(12, BaseType.ENUM, "backlight_mode"),
            new FieldDefinitionPrimitive(36, BaseType.ENUM, "activity_tracker_enabled"),
            new FieldDefinitionPrimitive(46, BaseType.ENUM, "move_alert_enabled"),
            new FieldDefinitionPrimitive(47, BaseType.ENUM, "date_mode"),
            new FieldDefinitionPrimitive(55, BaseType.ENUM, "display_orientation"),
            new FieldDefinitionPrimitive(56, BaseType.ENUM, "mounting_side"),
            new FieldDefinitionPrimitive(57, BaseType.UINT16, "default_page"),
            new FieldDefinitionPrimitive(58, BaseType.UINT16, "autosync_min_steps"),
            new FieldDefinitionPrimitive(59, BaseType.UINT16, "autosync_min_time"),
            new FieldDefinitionPrimitive(86, BaseType.ENUM, "ble_auto_upload_enabled"),
            new FieldDefinitionPrimitive(90, BaseType.UINT32, "auto_activity_detect")
    ));

    public static GlobalFITMessage USER_PROFILE = new GlobalFITMessage(3, "USER_PROFILE", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.STRING, 8, "friendly_name"),
            new FieldDefinitionPrimitive(1, BaseType.ENUM, "gender"),
            new FieldDefinitionPrimitive(2, BaseType.UINT8, "age"),
            new FieldDefinitionPrimitive(3, BaseType.UINT8, "height"),
            new FieldDefinitionPrimitive(4, BaseType.UINT16, "weight", 10, 0),
            new FieldDefinitionPrimitive(5, BaseType.ENUM, "language", FieldDefinitionFactory.FIELD.LANGUAGE),
            new FieldDefinitionPrimitive(6, BaseType.ENUM, "elev_setting", FieldDefinitionFactory.FIELD.MEASUREMENT_SYSTEM),
            new FieldDefinitionPrimitive(7, BaseType.ENUM, "weight_setting", FieldDefinitionFactory.FIELD.MEASUREMENT_SYSTEM),
            new FieldDefinitionPrimitive(8, BaseType.UINT8, "resting_heart_rate"),
            new FieldDefinitionPrimitive(10, BaseType.UINT8, "default_max_biking_heart_rate"),
            new FieldDefinitionPrimitive(11, BaseType.UINT8, "default_max_heart_rate"),
            new FieldDefinitionPrimitive(12, BaseType.ENUM, "hr_setting"),
            new FieldDefinitionPrimitive(13, BaseType.ENUM, "speed_setting", FieldDefinitionFactory.FIELD.MEASUREMENT_SYSTEM),
            new FieldDefinitionPrimitive(14, BaseType.ENUM, "dist_setting", FieldDefinitionFactory.FIELD.MEASUREMENT_SYSTEM),
            new FieldDefinitionPrimitive(16, BaseType.ENUM, "power_setting"),
            new FieldDefinitionPrimitive(17, BaseType.ENUM, "activity_class"),
            new FieldDefinitionPrimitive(18, BaseType.ENUM, "position_setting"),
            new FieldDefinitionPrimitive(21, BaseType.ENUM, "temperature_setting", FieldDefinitionFactory.FIELD.MEASUREMENT_SYSTEM),
            new FieldDefinitionPrimitive(28, BaseType.UINT32, "wake_time"),
            new FieldDefinitionPrimitive(29, BaseType.UINT32, "sleep_time"),
            new FieldDefinitionPrimitive(30, BaseType.ENUM, "height_setting", FieldDefinitionFactory.FIELD.MEASUREMENT_SYSTEM),
            new FieldDefinitionPrimitive(31, BaseType.UINT16, "user_running_step_length"),
            new FieldDefinitionPrimitive(32, BaseType.UINT16, "user_walking_step_length")
    ));

    public static GlobalFITMessage ZONES_TARGET = new GlobalFITMessage(7, "ZONES_TARGET", Arrays.asList(
            new FieldDefinitionPrimitive(3, BaseType.UINT16, "functional_threshold_power"),
            new FieldDefinitionPrimitive(1, BaseType.UINT8, "max_heart_rate"),
            new FieldDefinitionPrimitive(2, BaseType.UINT8, "threshold_heart_rate"),
            new FieldDefinitionPrimitive(5, BaseType.ENUM, "hr_calc_type"), //1=percent_max_hr
            new FieldDefinitionPrimitive(7, BaseType.ENUM, "pwr_calc_type") //1=percent_ftp
    ));

    public static GlobalFITMessage SPORT = new GlobalFITMessage(12, "SPORT", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.ENUM, "sport"),
            new FieldDefinitionPrimitive(1, BaseType.ENUM, "sub_sport"),
            new FieldDefinitionPrimitive(3, BaseType.STRING, 24, "name")
    ));

    public static GlobalFITMessage GOALS = new GlobalFITMessage(15, "GOALS", Arrays.asList(
            new FieldDefinitionPrimitive(4, BaseType.ENUM, "type", FieldDefinitionFactory.FIELD.GOAL_TYPE),
            new FieldDefinitionPrimitive(7, BaseType.UINT32, "target_value"),
            new FieldDefinitionPrimitive(11, BaseType.ENUM, "source", FieldDefinitionFactory.FIELD.GOAL_SOURCE)
    ));

    public static GlobalFITMessage SESSION = new GlobalFITMessage(18, "SESSION", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.ENUM, "event"), // 9 lap
            new FieldDefinitionPrimitive(1, BaseType.ENUM, "event_type"), // 1 stop
            new FieldDefinitionPrimitive(2, BaseType.UINT32, "start_time"),
            new FieldDefinitionPrimitive(3, BaseType.SINT32, "start_latitude"),
            new FieldDefinitionPrimitive(4, BaseType.SINT32, "start_longitude"),
            new FieldDefinitionPrimitive(7, BaseType.UINT32, "total_elapsed_time"), // with pauses
            new FieldDefinitionPrimitive(8, BaseType.UINT32, "total_timer_time"), // no pauses
            new FieldDefinitionPrimitive(9, BaseType.UINT32, "total_distance"),
            new FieldDefinitionPrimitive(11, BaseType.UINT16, "total_calories"),
            new FieldDefinitionPrimitive(22, BaseType.UINT16, "total_ascent"),
            new FieldDefinitionPrimitive(23, BaseType.UINT16, "total_descent"),
            new FieldDefinitionPrimitive(110, BaseType.STRING, 64, "sport_profile_name"),
            new FieldDefinitionPrimitive(253, BaseType.UINT32, "timestamp", FieldDefinitionFactory.FIELD.TIMESTAMP)
    ));

    public static GlobalFITMessage LAP = new GlobalFITMessage(19, "LAP", Arrays.asList(
            new FieldDefinitionPrimitive(253, BaseType.UINT32, "timestamp", FieldDefinitionFactory.FIELD.TIMESTAMP)
    ));

    public static GlobalFITMessage RECORD = new GlobalFITMessage(20, "RECORD", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.SINT32, "latitude"),
            new FieldDefinitionPrimitive(1, BaseType.SINT32, "longitude"),
            new FieldDefinitionPrimitive(3, BaseType.UINT8, "heart_rate"),
            new FieldDefinitionPrimitive(5, BaseType.UINT32, "distance", 100, 0), // m
            new FieldDefinitionPrimitive(73, BaseType.UINT32, "enhanced_speed"), // mm/s
            new FieldDefinitionPrimitive(78, BaseType.UINT32, "enhanced_altitude"), // dm
            new FieldDefinitionPrimitive(136, BaseType.UINT8, "wrist_heart_rate"),
            new FieldDefinitionPrimitive(143, BaseType.UINT8, "body_battery"),
            new FieldDefinitionPrimitive(253, BaseType.UINT32, "timestamp", FieldDefinitionFactory.FIELD.TIMESTAMP)
    ));

    public static GlobalFITMessage EVENT = new GlobalFITMessage(21, "EVENT", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.ENUM, "event"), // 0 timer, 74 sleep
            new FieldDefinitionPrimitive(1, BaseType.ENUM, "event_type"), // sleep: 0 start 1 stop, timer: 0 start 4 stop all
            new FieldDefinitionPrimitive(3, BaseType.UINT32, "data"), // in sleep they're timestamps in garmin epoch? in timer, 0 for manual
            new FieldDefinitionPrimitive(4, BaseType.UINT8, "event_group"), // 0?
            new FieldDefinitionPrimitive(253, BaseType.UINT32, "timestamp", FieldDefinitionFactory.FIELD.TIMESTAMP)
    ));

    public static GlobalFITMessage DEVICE_INFO = new GlobalFITMessage(23, "DEVICE_INFO", Arrays.asList(
            new FieldDefinitionPrimitive(2, BaseType.UINT16, "manufacturer"),
            new FieldDefinitionPrimitive(3, BaseType.UINT32Z, "serial_number"),
            new FieldDefinitionPrimitive(4, BaseType.UINT16, "product"),
            new FieldDefinitionPrimitive(5, BaseType.UINT16, "software_version"),
            new FieldDefinitionPrimitive(253, BaseType.UINT32, "timestamp", FieldDefinitionFactory.FIELD.TIMESTAMP)
    ));

    public static GlobalFITMessage FILE_CREATOR = new GlobalFITMessage(49, "FILE_CREATOR", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.UINT16, "software_version"),
            new FieldDefinitionPrimitive(1, BaseType.UINT8, "hardware_version")
    ));

    public static GlobalFITMessage MONITORING = new GlobalFITMessage(55, "MONITORING", Arrays.asList(
            new FieldDefinitionPrimitive(2, BaseType.UINT32, "distance"),
            new FieldDefinitionPrimitive(3, BaseType.UINT32, "cycles"),
            new FieldDefinitionPrimitive(4, BaseType.UINT32, "active_time"),
            new FieldDefinitionPrimitive(5, BaseType.ENUM, "activity_type"),
            new FieldDefinitionPrimitive(19, BaseType.UINT16, "active_calories"),
            new FieldDefinitionPrimitive(29, BaseType.UINT16, "duration_min"),
            new FieldDefinitionPrimitive(24, BaseType.BASE_TYPE_BYTE, "current_activity_type_intensity"),
            new FieldDefinitionPrimitive(26, BaseType.UINT16, "timestamp_16"),
            new FieldDefinitionPrimitive(27, BaseType.UINT8, "heart_rate"),
            new FieldDefinitionPrimitive(253, BaseType.UINT32, "timestamp", FieldDefinitionFactory.FIELD.TIMESTAMP)
    ));

    public static GlobalFITMessage CONNECTIVITY = new GlobalFITMessage(127, "CONNECTIVITY", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.ENUM, "bluetooth_enabled"),
            new FieldDefinitionPrimitive(3, BaseType.STRING, 20, "name"),
            new FieldDefinitionPrimitive(4, BaseType.ENUM, "live_tracking_enabled"),
            new FieldDefinitionPrimitive(5, BaseType.ENUM, "weather_conditions_enabled"),
            new FieldDefinitionPrimitive(6, BaseType.ENUM, "weather_alerts_enabled"),
            new FieldDefinitionPrimitive(7, BaseType.ENUM, "auto_activity_upload_enabled"),
            new FieldDefinitionPrimitive(8, BaseType.ENUM, "course_download_enabled"),
            new FieldDefinitionPrimitive(9, BaseType.ENUM, "workout_download_enabled"),
            new FieldDefinitionPrimitive(10, BaseType.ENUM, "gps_ephemeris_download_enabled")
    ));

    public static GlobalFITMessage WEATHER = new GlobalFITMessage(128, "WEATHER", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.ENUM, "weather_report"),
            new FieldDefinitionPrimitive(1, BaseType.SINT8, "temperature", FieldDefinitionFactory.FIELD.TEMPERATURE),
            new FieldDefinitionPrimitive(2, BaseType.ENUM, "condition", FieldDefinitionFactory.FIELD.WEATHER_CONDITION),
            new FieldDefinitionPrimitive(3, BaseType.UINT16, "wind_direction"),
            new FieldDefinitionPrimitive(4, BaseType.UINT16, "wind_speed", 298, 0),
            new FieldDefinitionPrimitive(5, BaseType.UINT8, "precipitation_probability"),
            new FieldDefinitionPrimitive(6, BaseType.SINT8, "temperature_feels_like", FieldDefinitionFactory.FIELD.TEMPERATURE),
            new FieldDefinitionPrimitive(7, BaseType.UINT8, "relative_humidity"),
            new FieldDefinitionPrimitive(8, BaseType.STRING, 15, "location"),
            new FieldDefinitionPrimitive(9, BaseType.UINT32, "observed_at_time", FieldDefinitionFactory.FIELD.TIMESTAMP),
            new FieldDefinitionPrimitive(10, BaseType.SINT32, "observed_location_lat"),
            new FieldDefinitionPrimitive(11, BaseType.SINT32, "observed_location_long"),
            new FieldDefinitionPrimitive(12, BaseType.ENUM, "day_of_week", FieldDefinitionFactory.FIELD.DAY_OF_WEEK),
            new FieldDefinitionPrimitive(13, BaseType.SINT8, "high_temperature", FieldDefinitionFactory.FIELD.TEMPERATURE),
            new FieldDefinitionPrimitive(14, BaseType.SINT8, "low_temperature", FieldDefinitionFactory.FIELD.TEMPERATURE),
            new FieldDefinitionPrimitive(15, BaseType.SINT8, "dew_point"),
            new FieldDefinitionPrimitive(16, BaseType.FLOAT32, "uv_index"),
            new FieldDefinitionPrimitive(17, BaseType.ENUM, "air_quality"),
            new FieldDefinitionPrimitive(253, BaseType.UINT32, "timestamp", FieldDefinitionFactory.FIELD.TIMESTAMP)
    ));

    public static GlobalFITMessage WATCHFACE_SETTINGS = new GlobalFITMessage(159, "WATCHFACE_SETTINGS", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.ENUM, "mode"), //1=analog
            new FieldDefinitionPrimitive(1, BaseType.BASE_TYPE_BYTE, "layout")
    ));

    public static GlobalFITMessage GPS_METADATA = new GlobalFITMessage(160, "GPS_METADATA", Arrays.asList(
            new FieldDefinitionPrimitive(3, BaseType.UINT32, "enhanced_altitude"),
            new FieldDefinitionPrimitive(4, BaseType.UINT32, "enhanced_speed")
    ));

    public static GlobalFITMessage FIELD_DESCRIPTION = new GlobalFITMessage(206, "FIELD_DESCRIPTION", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.UINT8, "developer_data_index"),
            new FieldDefinitionPrimitive(1, BaseType.UINT8, "field_definition_number"),
            new FieldDefinitionPrimitive(2, BaseType.UINT8, "fit_base_type_id"),
            new FieldDefinitionPrimitive(3, BaseType.STRING, 64, "field_name"),
            new FieldDefinitionPrimitive(8, BaseType.STRING, 16, "units")
    ));

    public static GlobalFITMessage DEVELOPER_DATA = new GlobalFITMessage(207, "DEVELOPER_DATA", Arrays.asList(
            new FieldDefinitionPrimitive(1, BaseType.BASE_TYPE_BYTE, 16, "application_id"),
            new FieldDefinitionPrimitive(3, BaseType.UINT8, "developer_data_index")
    ));

    public static GlobalFITMessage TIME_IN_ZONE = new GlobalFITMessage(216, "TIME_IN_ZONE", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.UINT16, "reference_message"),
            new FieldDefinitionPrimitive(1, BaseType.UINT16, "reference_index"),
            new FieldDefinitionPrimitive(2, BaseType.UINT32, "time_in_zone"), // seconds
            new FieldDefinitionPrimitive(6, BaseType.UINT8, "hr_zone_high_boundary"), // bpm
            new FieldDefinitionPrimitive(10, BaseType.ENUM, "hr_calc_type"), // 1 percent max hr
            new FieldDefinitionPrimitive(11, BaseType.UINT8, "max_heart_rate"),
            new FieldDefinitionPrimitive(12, BaseType.UINT8, "resting_heart_rate"),
            new FieldDefinitionPrimitive(13, BaseType.UINT8, "threshold_heart_rate"),
            new FieldDefinitionPrimitive(253, BaseType.UINT32, "timestamp", FieldDefinitionFactory.FIELD.TIMESTAMP)
    ));

    public static GlobalFITMessage ALARM_SETTINGS = new GlobalFITMessage(222, "ALARM_SETTINGS", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.UINT16, "time", FieldDefinitionFactory.FIELD.ALARM)
    ));

    public static GlobalFITMessage STRESS_LEVEL = new GlobalFITMessage(227, "STRESS_LEVEL", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.SINT16, "stress_level_value"),
            new FieldDefinitionPrimitive(1, BaseType.UINT32, "stress_level_time", FieldDefinitionFactory.FIELD.TIMESTAMP)
    ));

    public static GlobalFITMessage SPO2 = new GlobalFITMessage(269, "SPO2", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.UINT8, "reading_spo2"),
            new FieldDefinitionPrimitive(1, BaseType.UINT8, "reading_confidence"),
            new FieldDefinitionPrimitive(2, BaseType.UINT8, "mode"), // 3 periodic
            new FieldDefinitionPrimitive(253, BaseType.UINT32, "timestamp", FieldDefinitionFactory.FIELD.TIMESTAMP)
    ));

    public static GlobalFITMessage SLEEP_STAGE = new GlobalFITMessage(275, "SLEEP_STAGE", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.ENUM, "sleep_stage", FieldDefinitionFactory.FIELD.SLEEP_STAGE),
            new FieldDefinitionPrimitive(253, BaseType.UINT32, "timestamp", FieldDefinitionFactory.FIELD.TIMESTAMP)
    ));

    public static GlobalFITMessage RESPIRATION_RATE = new GlobalFITMessage(297, "RESPIRATION_RATE", Arrays.asList(
            new FieldDefinitionPrimitive(0, BaseType.SINT16, "respiration_rate"), // breaths / min, scaled by 100
            new FieldDefinitionPrimitive(253, BaseType.UINT32, "timestamp", FieldDefinitionFactory.FIELD.TIMESTAMP)
    ));

    public static GlobalFITMessage SLEEP_STATS = new GlobalFITMessage(346, "SLEEP_STATS", Arrays.asList(
    ));

    public static Map<Integer, GlobalFITMessage> KNOWN_MESSAGES = new HashMap<Integer, GlobalFITMessage>() {{
        put(0, FILE_ID);
        put(2, DEVICE_SETTINGS);
        put(3, USER_PROFILE);
        put(7, ZONES_TARGET);
        put(12, SPORT);
        put(15, GOALS);
        put(18, SESSION);
        put(19, LAP);
        put(20, RECORD);
        put(21, EVENT);
        put(23, DEVICE_INFO);
        put(49, FILE_CREATOR);
        put(55, MONITORING);
        put(127, CONNECTIVITY);
        put(128, WEATHER);
        put(159, WATCHFACE_SETTINGS);
        put(160, GPS_METADATA);
        put(206, FIELD_DESCRIPTION);
        put(207, DEVELOPER_DATA);
        put(216, TIME_IN_ZONE);
        put(222, ALARM_SETTINGS);
        put(227, STRESS_LEVEL);
        put(269, SPO2);
        put(275, SLEEP_STAGE);
        put(297, RESPIRATION_RATE);
        put(346, SLEEP_STATS);
    }};
    private final int number;
    private final String name;

    private final List<FieldDefinitionPrimitive> fieldDefinitionPrimitives;

    GlobalFITMessage(int number, String name, List<FieldDefinitionPrimitive> fieldDefinitionPrimitives) {
        this.number = number;
        this.name = name;
        this.fieldDefinitionPrimitives = fieldDefinitionPrimitives;
    }

    public static GlobalFITMessage fromNumber(final int number) {
        final GlobalFITMessage found = KNOWN_MESSAGES.get(number);
        if (found != null) {
            return found;
        }
        return new GlobalFITMessage(number, "UNK_" + number, null);
    }

    public String name() {
        return this.name;
    }

    public int getNumber() {
        return number;
    }

    public List<FieldDefinitionPrimitive> getFieldDefinitionPrimitives() {
        return fieldDefinitionPrimitives;
    }

    @Nullable
    public List<FieldDefinition> getFieldDefinitions(int... ids) {
        if (null == fieldDefinitionPrimitives)
            return null;
        List<FieldDefinition> subset = new ArrayList<>(ids.length);
        for (int id :
                ids) {
            for (FieldDefinitionPrimitive fieldDefinitionPrimitive :
                    fieldDefinitionPrimitives) {
                if (fieldDefinitionPrimitive.number == id) {
                    subset.add(FieldDefinitionFactory.create(
                            fieldDefinitionPrimitive.number,
                            fieldDefinitionPrimitive.size,
                            fieldDefinitionPrimitive.type,
                            fieldDefinitionPrimitive.baseType,
                            fieldDefinitionPrimitive.name,
                            fieldDefinitionPrimitive.scale,
                            fieldDefinitionPrimitive.offset
                    ));
                }
            }
        }
        return subset;
    }

    @Nullable
    public FieldDefinition getFieldDefinition(int id, int size) {
        if (null == fieldDefinitionPrimitives)
            return null;
        for (GlobalFITMessage.FieldDefinitionPrimitive fieldDefinitionPrimitive :
                fieldDefinitionPrimitives) {
            if (fieldDefinitionPrimitive.number == id) {
                return FieldDefinitionFactory.create(
                        fieldDefinitionPrimitive.number,
                        size,
                        fieldDefinitionPrimitive.type,
                        fieldDefinitionPrimitive.baseType,
                        fieldDefinitionPrimitive.name,
                        fieldDefinitionPrimitive.scale,
                        fieldDefinitionPrimitive.offset
                );
            }
        }
        return null;
    }

    public static class FieldDefinitionPrimitive {
        private final int number;
        private final BaseType baseType;
        private final String name;
        private final FieldDefinitionFactory.FIELD type;
        private final int scale;
        private final int offset;
        private final int size;

        public FieldDefinitionPrimitive(int number, BaseType baseType, int size, String name, FieldDefinitionFactory.FIELD type, int scale, int offset) {
            this.number = number;
            this.baseType = baseType;
            this.size = size;
            this.name = name;
            this.type = type;
            this.scale = scale;
            this.offset = offset;
        }

        public FieldDefinitionPrimitive(int number, BaseType baseType, String name, FieldDefinitionFactory.FIELD type) {
            this(number, baseType, baseType.getSize(), name, type, 1, 0);
        }

        public FieldDefinitionPrimitive(int number, BaseType baseType, String name) {
            this(number, baseType, baseType.getSize(), name, null, 1, 0);
        }

        public FieldDefinitionPrimitive(int number, BaseType baseType, int size, String name) {
            this(number, baseType, size, name, null, 1, 0);
        }

        public FieldDefinitionPrimitive(int number, BaseType baseType, String name, int scale, int offset) {
            this(number, baseType, baseType.getSize(), name, null, scale, offset);
        }

        public int getNumber() {
            return number;
        }

        public BaseType getBaseType() {
            return baseType;
        }

        public String getName() {
            return name;
        }

        public FieldDefinitionFactory.FIELD getType() {
            return type;
        }

        public int getScale() {
            return scale;
        }

        public int getOffset() {
            return offset;
        }

        public int getSize() {
            return size;
        }
    }
}