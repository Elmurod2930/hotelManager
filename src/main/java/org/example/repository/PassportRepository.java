package org.example.repository;

import org.example.entity.PassportEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PassportRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public PassportEntity getByNumber(String number) {
        Session session = sessionFactory.openSession();
        Query<PassportEntity> query = session.createQuery("from PassportEntity where number=:number and visible=true ", PassportEntity.class);
        query.setParameter("number", number);
        session.close();
        return query.getSingleResult();
    }

    public void add(PassportEntity entity) {
        Session session = sessionFactory.openSession();
        session.save(entity);
        session.close();
    }
}
