package org.example.repository;

import org.example.entity.EmployeeEntity;
import org.example.entity.TypeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TypeRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public TypeEntity getByName(String name) {
        Session session = sessionFactory.openSession();
        Query<TypeEntity> query = session.createQuery("from TypeEntity where name=:name and visible=true ", TypeEntity.class);
        query.setParameter("name", name);
        session.close();
        return query.getSingleResult();
    }

    public void add(TypeEntity entity) {
        Session session = sessionFactory.openSession();
        session.save(entity);
        session.close();
    }

    public List<TypeEntity> getList() {
        Session session = sessionFactory.openSession();
        Query<TypeEntity> query = session.createQuery("from TypeEntity where visible=true ", TypeEntity.class);
        session.close();
        return query.getResultList();
    }

    public TypeEntity getById(Integer id) {
        Session session = sessionFactory.openSession();
        Query<TypeEntity> query = session.createQuery("from TypeEntity where id=:id and visible=true ", TypeEntity.class);
        query.setParameter("id", id);
        session.close();
        return query.getSingleResult();
    }

    public void delete(TypeEntity entity) {
        Session session = sessionFactory.openSession();
        session.update(entity);
        session.close();
    }
}
