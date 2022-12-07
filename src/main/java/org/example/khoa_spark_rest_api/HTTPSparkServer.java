package org.example.khoa_spark_rest_api;

import lombok.extern.slf4j.Slf4j;
import org.example.khoa_spark_rest_api.common.Constant;
import org.example.khoa_spark_rest_api.common.JsonUtil;
import org.example.khoa_spark_rest_api.database.dao.EducationDAOImpl;
import org.example.khoa_spark_rest_api.database.dao.UserDAOImpl;

import static spark.Spark.*;

@Slf4j
public class HTTPSparkServer {
    private static HTTPSparkServer instance;

    public static HTTPSparkServer getInstance() {
        if (instance == null)
            instance = new HTTPSparkServer();
        return instance;
    }

    private HTTPSparkServer() {
    }

    public void start() {
        int port = Constant.SPARK_PORT;
        try {
            port(port);
            initRouter();
            log.info("Spark is listening at port: {}", port);
        } catch (Exception e) {
            log.error("Exception while starting spark server at {}", port, e);
        }
    }

    private void initRouter() {
        before("/*", ((request, response) -> {
            log.info("Received API Call: {}  {}", request.requestMethod(), request.pathInfo());
            log.info("Request Data: {}", JsonUtil.toJson(request.body()));
        }));

        after("/*", (((request, response) -> {
            response.type("application/json");
            log.info("Response Data: {}", response.body());
        })));

        exception(Exception.class, ((e, request, response) -> {
            // Code to handle exception
        }));

        initResumeRouter();
    }

    private void initResumeRouter() {
        ResumeController controller = new ResumeController(new UserDAOImpl(), new EducationDAOImpl());
        get("/resume/json", controller::getResumeJson);
    }
}
