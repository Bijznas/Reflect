package com.lft.reflect.service;

import com.lft.reflect.dao.StudentDaoImpl;
import com.lft.reflect.model.Student;

import java.util.List;

/**
 * Created by leapfrog on 7/12/16.
 */
public class StudentServiceImpl implements StudentService, ReflectService{

    @Override
    public List<Student> getAllStudents() {
        return new StudentDaoImpl().getAllStudents();
    }

    @Override
    public List<Student> getAll() {
        return new StudentDaoImpl().getAllStudents();
    }

    @Override
    public void add(Object o) {
        new StudentDaoImpl().add((Student)o);
    }
}
