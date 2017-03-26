package com.project.services.impl;

import com.project.dao.GenericDAO;
import com.project.dao.GenericDAOImpl;
import com.project.hibernate.model.Person;
import com.project.model.transer.PersonTransfer;
import com.project.services.PersonService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORGE-HP on 20/3/2017.
 */
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private GenericDAO<Person, Integer> personDAO;

    @PostConstruct
    public void init() {
        personDAO.setClassType(Person.class);
        System.out.println("PerosonDAO instanciado de GenericDAOImpl en PostConstruct de PersonServiceImp");
    }
    @Transactional
    public void addPerson(String firstName, String lastName, String email, String address) {
        Person p = new Person();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setEmail(email);
        p.setAddress(address);
        personDAO.save(p);
    }

    @Transactional
    public void addPerson(PersonTransfer personTransfer) {
        Person person = new Person();
        person.setFirstName(personTransfer.getFistName());
        person.setLastName(personTransfer.getLastNsme());
        personDAO.save(person);
    }
    public PersonTransfer findPerson(String username) {
        PersonTransfer personTransfer = new PersonTransfer();
        Person p;
        p =(Person) personDAO.getNamedQuery("getUserByUsername").setString("username", username).uniqueResult();
        if(p == null)
            return null;
        personTransfer.setFistName(p.getFirstName());
        personTransfer.setLastNsme(p.getLastName());
        return personTransfer;

    }
    @Transactional
    public List<PersonTransfer> listPersonsTransfer(){
        List<Person> personList = personDAO.findAll();
        List<PersonTransfer> personTransfers = new ArrayList<PersonTransfer>(personList.size());
        PersonTransfer personTransfer;
        for(Person e: personList) {
            personTransfer = new PersonTransfer();
            personTransfer.setFistName(e.getFirstName());
            personTransfer.setLastNsme(e.getLastName());
            personTransfers.add(personTransfer);
        }
        return personTransfers;
    }

    @Transactional
    public PersonTransfer findUserByUsername(String username) {
        Person person =(Person) personDAO.getNamedQuery("getUserByUsername").setString("username", username).uniqueResult();
        if(person == null)
            return null;
        PersonTransfer personTransfer = new PersonTransfer();
        personTransfer.setFistName(person.getFirstName());
        personTransfer.setLastNsme(person.getLastName());
        return personTransfer;
    }

}
