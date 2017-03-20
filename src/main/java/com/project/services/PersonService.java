package com.project.services;

import com.project.controller.PersonBean;
import com.project.model.Person;

import java.util.List;

/**
 * Created by JORGE-HP on 20/3/2017.
 */
public interface PersonService {
    void addPerson(PersonBean p);
    List<Person> listPersons();
}
