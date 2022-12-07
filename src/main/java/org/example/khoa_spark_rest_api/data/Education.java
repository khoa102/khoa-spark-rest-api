package org.example.khoa_spark_rest_api.data;

import org.example.khoa_spark_rest_api.database.entity.EducationEntity;

import java.time.LocalDateTime;

@SuppressWarnings("FieldCanBeLocal")
public class Education {
    private String schoolName;
    private String schoolLocation;
    private String typeOfDegree;
    private String fieldOfStudy;
    private LocalDateTime graduatedTime;

    public Education() {
    }

    public Education(EducationEntity educationEntity) {
        this.schoolName = educationEntity.getSchoolName();
        this.schoolLocation = educationEntity.getSchoolLocation();
        this.typeOfDegree = educationEntity.getTypeOfDegree();
        this.fieldOfStudy = educationEntity.getFieldOfStudy();
        this.graduatedTime = educationEntity.getGraduatedTime();
    }
}
