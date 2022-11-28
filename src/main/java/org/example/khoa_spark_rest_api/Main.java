package org.example.khoa_spark_rest_api;

import lombok.extern.slf4j.Slf4j;
import org.example.khoa_spark_rest_api.common.ServerUtil;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ServerUtil.setDefaultTimezoneToUtc();

        HTTPSparkServer.getInstance().start();
    }
}
