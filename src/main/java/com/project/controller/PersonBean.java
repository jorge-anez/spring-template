package com.project.controller;

import com.project.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;


@ManagedBean
@SessionScoped
@Component
public class PersonBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private PersonService personService;

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void save(){
        personService.addPerson(this);
    }
}
