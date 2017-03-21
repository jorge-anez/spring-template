package com.project.services.impl;

import com.project.controller.PersonBean;
import com.project.dao.PersonDAO;
import com.project.hibernate.model.Person;
import com.project.model.transfer.PersonResponse;
import com.project.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORGE-HP on 20/3/2017.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Transactional
    public void addPerson(PersonBean x) {
        Person p = new Person();
        p.setName(x.getName());
        personDAO.save(p);
    }

    @Transactional
    public List<PersonResponse> findAll() {
        List<PersonResponse> personResponseList = new ArrayList<PersonResponse>();

        List<Person> personList = personDAO.findAll();
        for (Person e: personList){
            PersonResponse p = new PersonResponse();
            p.setId(e.getId());
            p.setName(e.getName());
            p.setCountry(e.getCountry());
            personResponseList.add(p);
        }

        return personResponseList;
    }
}
