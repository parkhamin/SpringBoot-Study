package com.example.jpa.user.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "user")
public class UserEntity { // ORM: 데이터베이스 오브젝트와 데이터베이스에 있는 컬럼값들을 맵핑해주는 것
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // MYSQL 데이터베이스에 의해서 auto-generate 될 것

    private String name;
    private Integer age;
    private String email;
}
