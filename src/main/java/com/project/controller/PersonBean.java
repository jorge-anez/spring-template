package com.project.controller;

import com.project.model.transfer.PersonResponse;
import com.project.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


@ManagedBean
@SessionScoped
@Component
public class PersonBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private final static List<String> VALID_COLUMN_KEYS = Arrays.asList("id", "brand", "year", "color", "price");

    @Autowired
    private PersonService personService;

    private String name;
    private List<PersonResponse> personResponseList;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void save(){
        personService.addPerson(this);
    }

    public List<PersonResponse> getPersonResponseList() {
        personResponseList = personService.findAll();
        return personResponseList;
    }

    public void setPersonResponseList(List<PersonResponse> personResponseList) {
        this.personResponseList = personResponseList;
    }
}
