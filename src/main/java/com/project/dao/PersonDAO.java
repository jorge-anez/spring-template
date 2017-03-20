package com.project.dao;

/**
 * Created by JORGE-HP on 31/1/2017.
 */
import com.project.model.Person;

import java.util.List;

public interface PersonDAO {

    public void save(Person p);

    public List<Person> list();

}
