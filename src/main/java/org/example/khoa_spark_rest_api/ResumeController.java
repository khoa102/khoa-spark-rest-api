package org.example.khoa_spark_rest_api;

import org.example.khoa_spark_rest_api.common.JsonUtil;
import org.example.khoa_spark_rest_api.data.Resume;
import spark.Request;
import spark.Response;

public class ResumeController {

    public String getResumeJson(Request request, Response response) {
        Resume resume = new Resume();
        resume.setName("Anh Khoa Tran");
        resume.setTitle("Java Developer");

        // Contact
        resume.setEmail("khoa102@gmail.com");
        resume.setAddress("Burnaby, BC, V5J 1N9");

        resume.setSummary("Result-oriented software engineer with 3+ years of experience working with Java. Experienced in working with AWS, Docker, Kubernetes, SQL. Skilled in backend development and frontend JavaFX development");

        return JsonUtil.toJson(resume);
    }
}
