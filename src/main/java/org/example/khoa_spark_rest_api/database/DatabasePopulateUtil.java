package org.example.khoa_spark_rest_api.database;

import org.example.khoa_spark_rest_api.database.dao.EducationDAO;
import org.example.khoa_spark_rest_api.database.dao.EducationDAOImpl;
import org.example.khoa_spark_rest_api.database.dao.UserDAO;
import org.example.khoa_spark_rest_api.database.dao.UserDAOImpl;
import org.example.khoa_spark_rest_api.database.entity.EducationEntity;
import org.example.khoa_spark_rest_api.database.entity.UserEntity;

import java.time.LocalDateTime;

public class DatabasePopulateUtil {
    public static void populateDBData() {
        UserEntity userEntity = new UserEntity("Anh Khoa Tran", "Java Developer", "khoa102@gmail.com", "Burnaby, BC, V5J 1N9", "");
        userEntity.setSummary("Result-oriented software engineer with 3+ years of experience working with Java. Experienced in working with AWS, Docker, Kubernetes, SQL. Skilled in backend development and frontend JavaFX development");
        EducationEntity entity = new EducationEntity("University of Mississippi", "University, MS, US", "Bachelor", "Computer Science", LocalDateTime.of(2019, 5, 1, 0, 0, 0));
        entity.setUser(userEntity);

        UserDAO userDAO = new UserDAOImpl();
        userDAO.save(userEntity);

        EducationDAO educationDAO = new EducationDAOImpl();
        educationDAO.save(entity);
    }
}
