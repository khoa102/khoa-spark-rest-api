package org.example.khoa_spark_rest_api.common;

import com.google.common.base.Strings;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeFormatter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constant.MAIN_JSON_DATETIME_FORMAT);

    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final String dateAsString = json.getAsString();
        return Strings.isNullOrEmpty(dateAsString) ? null : LocalDateTime.from(formatter.parse(dateAsString));
    }

    @Override
    public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src == null ? "" : src.format(formatter));
    }
}
