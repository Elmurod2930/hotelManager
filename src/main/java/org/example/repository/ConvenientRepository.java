package org.example.repository;

import org.example.entity.ConvenientEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConvenientRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public ConvenientEntity getByName(String name) {
        Session session = sessionFactory.openSession();
        Query<ConvenientEntity> query = session.createQuery("from ConvenientEntity where description=:name and visible=true ", ConvenientEntity.class);
        query.setParameter("name", name);
        session.close();
        return query.getSingleResult();
    }

    public void add(ConvenientEntity entity) {
        Session session = sessionFactory.openSession();
        session.save(entity);
        session.close();
    }

    public List<ConvenientEntity> getList() {
        Session session = sessionFactory.openSession();
        Query<ConvenientEntity> query = session.createQuery("from ConvenientEntity where visible=true ", ConvenientEntity.class);
        List<ConvenientEntity> list = query.getResultList();
        session.close();
        return list;
    }

    public ConvenientEntity getById(Integer id) {
        Session session = sessionFactory.openSession();
        Query<ConvenientEntity> query = session.createQuery("from ConvenientEntity where id=:id and visible=true ", ConvenientEntity.class);
        query.setParameter("id", id);
        session.close();
        return query.getSingleResult();
    }

    public void delete(ConvenientEntity entity) {
        Session session = sessionFactory.openSession();
        session.update(entity);
        session.close();
    }
}
