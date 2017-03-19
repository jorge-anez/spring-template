package com.project.dao;

/**
 * Created by JORGE-HP on 31/1/2017.
 */
import java.util.List;

import com.project.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PersonDAOImpl implements PersonDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(Person p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }

    public List<Person> list() {
        Session session = this.sessionFactory.openSession();
        List<Person> personList = session.createQuery("from Person").list();
        session.close();
        return personList;
    }

    public Person getPerson(){
        Session session = this.sessionFactory.openSession();
        List<Person> list = session.getNamedQuery("getMale").list();
        if(list != null && !list.isEmpty())
            return list.get(0);
        return null;
    }
}


