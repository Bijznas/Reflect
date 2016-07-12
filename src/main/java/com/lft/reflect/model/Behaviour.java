package com.lft.reflect.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by leapfrog on 7/12/16.
 */
@Entity
@Table(name = "behaviour")
public class Behaviour implements Serializable {

    private static final long serialVersionUID = -6348775344191954345L;

    private Integer id;
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "type", unique = true, nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
