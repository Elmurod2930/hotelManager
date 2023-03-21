package org.example.repository;

import org.example.entity.BookingEntity;
import org.example.entity.GuestEntity;
import org.example.entity.RoomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void makeBooking(BookingEntity entity) {
        Session session = sessionFactory.openSession();
        try {
            session.save(entity);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<BookingEntity> getList() {
        Session session = sessionFactory.openSession();
        try {
            Query<BookingEntity> query = session.createQuery("from BookingEntity ", BookingEntity.class);
            return query.getResultList();
        } catch (IllegalStateException e) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<BookingEntity> getListByRoom(RoomEntity room) {
        Session session = sessionFactory.openSession();
        try {
            Query<BookingEntity> query = session.createQuery("from BookingEntity where room=:room", BookingEntity.class);
            query.setParameter("room", room);
            return query.getResultList();
        } catch (IllegalStateException e) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<BookingEntity> getListByGuest(GuestEntity guest) {
        Session session = sessionFactory.openSession();
        try {
            Query<BookingEntity> query = session.createQuery("from BookingEntity where guest=:guest", BookingEntity.class);
            query.setParameter("guest", guest);
            return query.getResultList();
        } catch (IllegalStateException e) {
            return null;
        } finally {
            session.close();
        }
    }
}
