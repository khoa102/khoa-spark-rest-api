package org.example.khoa_spark_rest_api;

import lombok.extern.slf4j.Slf4j;
import org.example.khoa_spark_rest_api.common.JsonUtil;
import org.example.khoa_spark_rest_api.data.Education;
import org.example.khoa_spark_rest_api.data.Resume;
import org.example.khoa_spark_rest_api.database.dao.EducationDAO;
import org.example.khoa_spark_rest_api.database.dao.UserDAO;
import org.example.khoa_spark_rest_api.database.entity.UserEntity;
import spark.Request;
import spark.Response;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class ResumeController {
    private final UserDAO userDAO;
    private final EducationDAO educationDAO;

    public ResumeController(UserDAO userDAO, EducationDAO educationDAO) {
        this.userDAO = userDAO;
        this.educationDAO = educationDAO;
    }

    public String getResumeJson(Request request, Response response) {
        UserEntity user = userDAO.getById(1);
        List<Education> educationList = user.getEducations()
                .stream()
                .map(Education::new)
                .collect(Collectors.toList());

        Resume resume = new Resume(user);
        resume.setEducations(educationList);

        return JsonUtil.toJson(resume);
    }
}
