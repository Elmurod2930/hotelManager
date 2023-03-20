package org.example.repository;

import org.example.entity.GuestEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GuestRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(GuestEntity entity) {
        Session session = sessionFactory.openSession();
        session.save(entity);
        session.close();
    }

    public List<GuestEntity> getList() {
        Session session = sessionFactory.openSession();
        Query<GuestEntity> query = session.createQuery("from GuestEntity where visible=true ", GuestEntity.class);
        session.close();
        return query.getResultList();
    }

    public GuestEntity getById(Integer guestId) {
        Session session = sessionFactory.openSession();
        Query<GuestEntity> query = session.createQuery("from GuestEntity where visible=true ", GuestEntity.class);
        session.close();
        return query.getSingleResult();
    }
}
