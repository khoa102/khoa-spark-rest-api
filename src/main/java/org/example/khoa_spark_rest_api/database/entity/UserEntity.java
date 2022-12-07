package org.example.khoa_spark_rest_api.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@SuppressWarnings("JpaDataSourceORMInspection")
@Setter
@Getter
@Entity
@Table(name="Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String name;
    private String title;
    private String email;
    private String phoneNum;
    private String address;
    private String summary;

    @OneToMany(mappedBy = "user")
    private Set<EducationEntity> educations;

    public UserEntity() {
    }

    public UserEntity(String name, String title, String email, String address, String summary) {
        this.name = name;
        this.title = title;
        this.email = email;
        this.address = address;
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
