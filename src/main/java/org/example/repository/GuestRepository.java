package org.example.repository;

import org.example.entity.ConvenientEntity;
import org.example.entity.EmployeeEntity;
import org.example.entity.GuestEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class GuestRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(GuestEntity entity) {
        Session session = sessionFactory.openSession();
        try {
            session.save(entity);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<GuestEntity> getList() {
        Session session = sessionFactory.openSession();
        try {
            Query<GuestEntity> query = session.createQuery("from GuestEntity where visible=true ", GuestEntity.class);
            return query.getResultList();
        } catch (IllegalStateException e) {
            return null;
        } finally {
            session.close();
        }
    }

    public GuestEntity getById(Integer guestId) {
        Session session = sessionFactory.openSession();
        try {
            Query<GuestEntity> query = session.createQuery("from GuestEntity where visible=true and id=:id", GuestEntity.class);
            query.setParameter("id", guestId);
            return query.getSingleResult();
        } catch (IllegalStateException | NoResultException e) {
            return null;
        } finally {
            session.close();
        }
    }
}
