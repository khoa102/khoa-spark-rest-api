package org.example.khoa_spark_rest_api;

import lombok.extern.slf4j.Slf4j;
import org.example.khoa_spark_rest_api.common.JsonUtil;
import org.example.khoa_spark_rest_api.common.ServerUtil;
import org.example.khoa_spark_rest_api.database.dao.EducationDAO;
import org.example.khoa_spark_rest_api.database.dao.EducationDAOImpl;
import org.example.khoa_spark_rest_api.database.entity.EducationEntity;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ServerUtil.setDefaultTimezoneToUtc();

        HTTPSparkServer.getInstance().start();

        EducationEntity entity = new EducationEntity("University of Mississippi", "University, MS, US", "Bachelor", "Computer Science", LocalDateTime.of(2019, 5, 1, 0, 0, 0));

        EducationDAO dao = new EducationDAOImpl();
        dao.save(entity);

        List<EducationEntity> all = dao.getAll();
        all.forEach(educationEntity -> System.out.println(JsonUtil.toJson(educationEntity)));
    }
}
