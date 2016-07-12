package com.lft.reflect.service;

import com.lft.reflect.model.Student;

import java.util.List;

/**
 * Created by leapfrog on 7/12/16.
 */
public interface ReflectService {

    List getAll();

    void add(Object o);
}
