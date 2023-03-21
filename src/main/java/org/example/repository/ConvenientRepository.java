package org.example.repository;

import org.example.entity.BookingEntity;
import org.example.entity.ConvenientEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class ConvenientRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public ConvenientEntity getByName(String name) {
        Session session = sessionFactory.openSession();
        try {
            Query<ConvenientEntity> query = session.createQuery("from ConvenientEntity where description=:name and visible=true ", ConvenientEntity.class);
            query.setParameter("name", name);
            return query.getSingleResult();
        } catch (IllegalStateException | NoResultException e) {
            return null;
        }finally {
            session.close();
        }
    }

    public void add(ConvenientEntity entity) {
        Session session = sessionFactory.openSession();
        try {
            session.save(entity);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<ConvenientEntity> getList() {
        Session session = sessionFactory.openSession();
        try {
            Query<ConvenientEntity> query = session.createQuery("from ConvenientEntity where visible=true ", ConvenientEntity.class);
            return query.getResultList();
        } catch (IllegalStateException e) {
            return null;
        } finally {
            session.close();
        }
    }


    public ConvenientEntity getById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            Query<ConvenientEntity> query = session.createQuery("from ConvenientEntity where id=:id and visible=true ", ConvenientEntity.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (IllegalStateException | NoResultException e) {
            return null;
        } finally {
            session.close();
        }
    }

    public void delete(ConvenientEntity entity) {
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
