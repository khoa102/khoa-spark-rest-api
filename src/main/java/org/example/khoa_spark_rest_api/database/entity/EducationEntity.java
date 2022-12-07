package org.example.khoa_spark_rest_api.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@SuppressWarnings("JpaDataSourceORMInspection")
@Setter
@Getter
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

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private UserEntity user;

    public EducationEntity() {
    }

    public EducationEntity(String schoolName, String schoolLocation, String typeOfDegree, String fieldOfStudy, LocalDateTime graduatedTime) {
        this.schoolName = schoolName;
        this.schoolLocation = schoolLocation;
        this.typeOfDegree = typeOfDegree;
        this.fieldOfStudy = fieldOfStudy;
        this.graduatedTime = graduatedTime;
    }

    @Override
    public String toString() {
        return "EducationEntity{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                ", schoolLocation='" + schoolLocation + '\'' +
                ", typeOfDegree='" + typeOfDegree + '\'' +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", graduatedTime=" + graduatedTime +
                ", user=" + user +
                '}';
    }
}
