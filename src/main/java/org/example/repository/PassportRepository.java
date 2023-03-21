package org.example.repository;

import org.example.entity.GuestEntity;
import org.example.entity.PassportEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

@Repository
public class PassportRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public PassportEntity getByNumber(String number) {
        Session session = sessionFactory.openSession();
        try {
            Query<PassportEntity> query = session.createQuery("from PassportEntity where number=:number and visible=true ", PassportEntity.class);
            query.setParameter("number", number);
            return query.getSingleResult();
        } catch (IllegalStateException | NoResultException e) {
            return null;
        } finally {
            session.close();
        }
    }

    public void add(PassportEntity entity) {
        Session session = sessionFactory.openSession();
        try {
            session.save(entity);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
