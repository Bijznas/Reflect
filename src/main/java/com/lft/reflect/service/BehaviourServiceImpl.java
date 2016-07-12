package com.lft.reflect.service;

import com.lft.reflect.dao.BehaviourDaoImpl;
import com.lft.reflect.model.Behaviour;

import java.util.List;

/**
 * Created by leapfrog on 7/12/16.
 */
public class BehaviourServiceImpl implements BehaviourService, ReflectService {
    @Override
    public List getAllBehaviours() {
        return new BehaviourDaoImpl().getAllBehaviours();
    }

    @Override
    public List getAll() {
        return new BehaviourDaoImpl().getAllBehaviours();
    }

    @Override
    public void add(Object o) {
        new BehaviourDaoImpl().add((Behaviour)o);
    }
}
