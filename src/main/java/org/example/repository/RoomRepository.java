package org.example.repository;

import org.example.entity.RoomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(RoomEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

    public List<RoomEntity> list() {
        Session session = sessionFactory.openSession();
        Query<RoomEntity> query = session.createQuery("from RoomEntity where visible=true ", RoomEntity.class);
        List<RoomEntity> list = query.getResultList();
        session.close();
        return list;
    }

    public RoomEntity getById(Integer id) {
        Session session = sessionFactory.openSession();
        Query<RoomEntity> queue = session.createQuery("from RoomEntity where id=:id and visible=true ", RoomEntity.class);
        queue.setParameter("id", id);
        RoomEntity entity = queue.getSingleResult();
        session.close();
        return entity;
    }

    public void delete(RoomEntity entity) {
        Session session = sessionFactory.openSession();
        session.update(entity);
        session.close();
    }
}
