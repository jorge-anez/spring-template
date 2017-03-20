package com.project.services.impl;

import com.project.controller.PersonBean;
import com.project.dao.PersonDAO;
import com.project.model.Person;
import com.project.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Person> listPersons() {
        return null;
    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
}
