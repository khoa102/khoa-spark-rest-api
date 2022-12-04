package org.example.khoa_spark_rest_api.database.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="Education")
public class EducationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String schoolName;
    private String schoolLocation;
    private String typeOfDegree;
    private String fieldOfStudy;
    private LocalDateTime graduatedTime;

    public EducationEntity() {
    }

    public EducationEntity(String schoolName, String schoolLocation, String typeOfDegree, String fieldOfStudy, LocalDateTime graduatedTime) {
        this.schoolName = schoolName;
        this.schoolLocation = schoolLocation;
        this.typeOfDegree = typeOfDegree;
        this.fieldOfStudy = fieldOfStudy;
        this.graduatedTime = graduatedTime;
    }
}
