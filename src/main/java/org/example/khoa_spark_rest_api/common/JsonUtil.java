package org.example.khoa_spark_rest_api.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.graph.GraphAdapterBuilder;
import org.example.khoa_spark_rest_api.database.entity.EducationEntity;
import org.example.khoa_spark_rest_api.database.entity.UserEntity;

import java.time.LocalDateTime;

public class JsonUtil {
    private static final Gson gsonMain;
    static {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeFormatter())
                .disableHtmlEscaping();
        new GraphAdapterBuilder()
                .addType(UserEntity.class)
                .addType(EducationEntity.class)
                .registerOn(gsonBuilder);
        gsonMain = gsonBuilder.create();
    }


    public static String toJson(Object toJsonObject) {
        return gsonMain.toJson(toJsonObject);
    }
}
