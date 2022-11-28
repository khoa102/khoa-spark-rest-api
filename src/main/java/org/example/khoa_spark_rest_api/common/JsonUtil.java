package org.example.khoa_spark_rest_api.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;

public class JsonUtil {
    private static final Gson gsonMain = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeFormatter())
            .disableHtmlEscaping()
            .create();


    public static String toJson(Object toJsonObject) {
        return gsonMain.toJson(toJsonObject);
    }
}
