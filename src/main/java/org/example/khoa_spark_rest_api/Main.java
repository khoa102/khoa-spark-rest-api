package org.example.khoa_spark_rest_api;

import lombok.extern.slf4j.Slf4j;
import org.example.khoa_spark_rest_api.common.JsonUtil;
import org.example.khoa_spark_rest_api.common.ServerUtil;
import org.example.khoa_spark_rest_api.database.DatabasePopulateUtil;
import org.example.khoa_spark_rest_api.database.dao.EducationDAO;
import org.example.khoa_spark_rest_api.database.dao.EducationDAOImpl;
import org.example.khoa_spark_rest_api.database.dao.UserDAO;
import org.example.khoa_spark_rest_api.database.dao.UserDAOImpl;
import org.example.khoa_spark_rest_api.database.entity.EducationEntity;
import org.example.khoa_spark_rest_api.database.entity.UserEntity;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ServerUtil.setDefaultTimezoneToUtc();

        HTTPSparkServer.getInstance().start();

        DatabasePopulateUtil.populateDBData();

        // Test out data in DB
        UserDAO userDAO = new UserDAOImpl();
        EducationDAO educationDAO = new EducationDAOImpl();

        List<EducationEntity> allEducation = educationDAO.getAll();
        allEducation.forEach(educationEntity -> System.out.println(JsonUtil.toJson(educationEntity)));

        List<UserEntity> allUser = userDAO.getAll();
        allUser.forEach(userEntity1 -> System.out.println(JsonUtil.toJson(userEntity1)));
    }
}
