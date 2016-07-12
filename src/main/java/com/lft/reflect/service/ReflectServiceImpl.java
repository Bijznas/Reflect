package com.lft.reflect.service;

import com.lft.reflect.dao.ReflectDaoImpl;
import com.lft.reflect.model.Behaviour;
import com.lft.reflect.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Created by leapfrog on 7/12/16.
 */
public class ReflectServiceImpl implements ReflectService {

    @Override
    public List getAll(String className) {
        return new ReflectDaoImpl().getAll(className);
    }

    @Override
    public void saveOrUpdate(Object o) {
        new ReflectDaoImpl().saveOrUpdate(o);
    }

    @Override
    public Class getClassFromResource(String resourceName) throws ClassNotFoundException{
        String singularResource = Utils.getSingularOf(resourceName);
        return Class.forName("com.lft.reflect.model." + Utils.toCamelCaseUpper(singularResource));
    }

    @Override
    public Object constructObjectFrom(Class aClass, Map map, Integer id) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
        Object object = aClass.newInstance();
        Method[] methods = aClass.getMethods();

        for(Method method : methods){
            if(Utils.isSetter(method) && method.getName() != "setId") {
                method.invoke(object, map.get(Utils.decapitalizeFirstLetter(method.getName().split("set")[1])));
            }
        }

        if(id !=null){
            Method method = aClass.getMethod("setId", new Class[]{Integer.class});
            method.invoke(object, id);
        }

        return object;
    }
}
