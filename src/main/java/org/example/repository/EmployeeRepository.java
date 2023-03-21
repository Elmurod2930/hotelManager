package org.example.repository;

import org.example.entity.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    SessionFactory sessionFactory;

    public void add(EmployeeEntity entity) {
        Session session = sessionFactory.openSession();
        try {
            session.save(entity);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<EmployeeEntity> getList() {
        Session session = sessionFactory.openSession();
        try {
            Query<EmployeeEntity> query = session.createQuery("from EmployeeEntity where status = 'ACTIVE'", EmployeeEntity.class);
            return query.getResultList();
        } catch (IllegalStateException e) {
            return null;
        } finally {
            session.close();
        }
    }

    public EmployeeEntity getById(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            Query<EmployeeEntity> query = session.createQuery("from EmployeeEntity where id=:id", EmployeeEntity.class);
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    public EmployeeEntity getByPhone(String phone) {
        Session session = sessionFactory.openSession();
        try {
            Query<EmployeeEntity> query = session.createQuery("from EmployeeEntity where phone = :phone", EmployeeEntity.class);
            query.setParameter("phone", phone);
            return query.getSingleResult();
        } catch (IllegalStateException | NoResultException e) {
            return null;
        } finally {
            session.close();
        }
    }

    public void delete(EmployeeEntity entity) {
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
