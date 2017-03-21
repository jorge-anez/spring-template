package com.project.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 3/21/2017.
 */
@Repository
public class GenericDAOImpl<T, K extends Serializable> implements GenericDAO<T, K> {

    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> classType;

    public K save(T t) {
        Session session = this.sessionFactory.getCurrentSession();
        K key = (K)session.save(t);
        return key;
    }

    public void update(T t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(t);
    }

    public void remove(T t) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(t);
    }

    public T find(K key) {
        Session session = sessionFactory.getCurrentSession();
        T t = (T)session.load(classType, key);
        return t;
    }

    public List<T> findAll() {
        return findByCriteria(new Criterion[0]);
    }

    public List<T> findByCriteria(Criterion... criterions) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(classType);
        for(Criterion c: criterions)
            criteria.add(c);
        return criteria.list();
    }

    public Query getNamedQuery(String name) {
        return sessionFactory.getCurrentSession().getNamedQuery(name);
    }

    public SessionFactory getSession() {
        return sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Class<T> getClassType() {
        return classType;
    }

    public void setClassType(Class<T> classType) {
        this.classType = classType;
    }
}
