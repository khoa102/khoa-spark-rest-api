package org.example.khoa_spark_rest_api.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Resume {
    private String name;
    private String title;

    // Contact
    private String email;
    private String phoneNum;
    private String address;

    // Work
    private String summary;

    // Work Exp
    private List<WorkExperience> workExperiences;

    // Education
    private List<Education> educations;
}
