package com.lft.reflect.dao;

import com.lft.reflect.model.Behaviour;

import java.util.List;

/**
 * Created by leapfrog on 7/12/16.
 */
public interface BehaviourDao {
    List<Behaviour> getAllBehaviours();
    void add(Behaviour behaviour);
}
