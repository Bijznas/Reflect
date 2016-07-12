package com.lft.reflect.service;

import com.lft.reflect.model.Student;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Created by leapfrog on 7/12/16.
 */
public interface ReflectService {

    List getAll(String className);

    void saveOrUpdate(Object o);

    Class getClassFromResource(String resourceName) throws ClassNotFoundException;

    Object constructObjectFrom(Class aClass, Map map, Integer id) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException;
}
