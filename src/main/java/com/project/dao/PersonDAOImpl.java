package com.project.dao;

/**
 * Created by JORGE-HP on 31/1/2017.
 */
import com.project.hibernate.model.Person;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class PersonDAOImpl extends GenericDAOImpl<Person, Integer> implements PersonDAO{
    public void method1() {}

    @PostConstruct
    public void init(){
        super.setClassType(Person.class);
    }
}


