package org.example.khoa_spark_rest_api.common;

import java.util.TimeZone;

public class ServerUtil {
    public static void setDefaultTimezoneToUtc() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
