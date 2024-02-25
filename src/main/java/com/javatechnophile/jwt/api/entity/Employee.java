package com.javatechnophile.jwt.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_TBL")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private int employeeId;
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private int age;
    private String nationality;
}
