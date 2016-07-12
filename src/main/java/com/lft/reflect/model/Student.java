package com.lft.reflect.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by leapfrog on 7/11/16.
 */
@Entity
@Table(name = "student", uniqueConstraints = {
        @UniqueConstraint(columnNames = "code") })
public class Student implements Serializable {

    private static final long serialVersionUID = -6403807506004261432L;
    private Integer id;
    private String code;
    private String name;
    private Integer currentClass;

    public Student() {
    }

    public Student(Integer id, String code, String name, Integer currentClass) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.currentClass = currentClass;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "code", unique = true, nullable = false, length = 10)
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "class", nullable = false, length = 2)
    public Integer getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(Integer currentClass) {
        this.currentClass = currentClass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", currentClass=" + currentClass +
                '}';
    }
}
