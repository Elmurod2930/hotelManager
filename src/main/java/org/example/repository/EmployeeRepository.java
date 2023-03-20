package org.example.repository;

import org.example.entity.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    SessionFactory sessionFactory;

    public void add(EmployeeEntity entity) {
        Session session = sessionFactory.openSession();
        session.save(entity);
        session.close();
    }

    public List<EmployeeEntity> getList() {
        Session session = sessionFactory.openSession();
        Query<EmployeeEntity> query = session.createQuery("from EmployeeEntity where status = 'ACTIVE'", EmployeeEntity.class);
        session.close();
        return query.getResultList();
    }

    public EmployeeEntity getById(Integer id) {
        Session session = sessionFactory.openSession();
        Query<EmployeeEntity> query = session.createQuery("from EmployeeEntity where id=:id", EmployeeEntity.class);
        query.setParameter("id", id);
        session.close();
        return query.getSingleResult();
    }

    public void delete(EmployeeEntity entity) {
        Session session = sessionFactory.openSession();
        session.update(entity);
        session.close();
    }
}
