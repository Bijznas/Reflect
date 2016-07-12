package com.lft.reflect.dao;

import com.lft.reflect.model.Student;

import java.util.List;

/**
 * Created by leapfrog on 7/12/16.
 */
public interface ReflectDao {
    List getAll(String className);
    void saveOrUpdate(Object obj);
}
