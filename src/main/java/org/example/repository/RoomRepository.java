package org.example.repository;

import org.example.entity.RoomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class RoomRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(RoomEntity entity) {
        Session session = sessionFactory.openSession();
        try {
            session.save(entity);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<RoomEntity> list() {
        Session session = sessionFactory.openSession();
        try {
            Query<RoomEntity> query = session.createQuery("from RoomEntity where visible=true ", RoomEntity.class);
            return query.getResultList();
        } catch (IllegalStateException e) {
            return null;
        } finally {
            session.close();
        }
    }

    public RoomEntity getById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            Query<RoomEntity> queue = session.createQuery("from RoomEntity where id=:id and visible=true ", RoomEntity.class);
            queue.setParameter("id", id);
            return queue.getSingleResult();
        } catch (IllegalStateException | NoResultException e) {
            return null;
        } finally {
            session.close();
        }
    }

    public void delete(RoomEntity entity) {
        Session session = sessionFactory.openSession();
        try {
            session.update(entity);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
