package com.project.services;

import com.project.controller.PersonBean;
import com.project.model.transer.PersonTransfer;

import java.util.List;

/**
 * Created by JORGE-HP on 20/3/2017.
 */
public interface PersonService {
    void addPerson(String firstName, String lastName, String email, String address);
    void addPerson(PersonTransfer p);
    List<PersonTransfer> listPersonsTransfer();
    PersonTransfer findUserByUsername(String username);
}
