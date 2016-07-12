package com.lft.reflect.dao;

import com.lft.reflect.model.Student;

import java.util.List;

/**
 * Created by leapfrog on 7/11/16.
 */

public interface StudentDao {

    List<Student> getAllStudents();
    void add(Student student);
}
