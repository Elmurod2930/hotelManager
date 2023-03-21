package org.example.repository;

import org.example.entity.EmployeeEntity;
import org.example.entity.RoomEntity;
import org.example.entity.TypeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class TypeRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public TypeEntity getByName(String name) {
        Session session = sessionFactory.openSession();
        try {
            Query<TypeEntity> query = session.createQuery("from TypeEntity where name=:name and visible=true ", TypeEntity.class);
            query.setParameter("name", name);
            return query.getSingleResult();
        } catch (IllegalStateException | NoResultException e) {
            return null;
        } finally {
            session.close();
        }
    }

    public void add(TypeEntity entity) {
        Session session = sessionFactory.openSession();
        try {
            session.save(entity);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<TypeEntity> getList() {
        Session session = sessionFactory.openSession();
        try {
            Query<TypeEntity> query = session.createQuery("from TypeEntity where visible=true ", TypeEntity.class);
            return query.getResultList();
        } catch (IllegalStateException e) {
            return null;
        } finally {
            session.close();
        }
    }

    public TypeEntity getById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            Query<TypeEntity> query = session.createQuery("from TypeEntity where id=:id and visible=true ", TypeEntity.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (IllegalStateException | NoResultException e) {
            return null;
        } finally {
            session.close();
        }
    }

    public void delete(TypeEntity entity) {
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
