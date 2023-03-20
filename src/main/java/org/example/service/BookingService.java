package org.example.service;

import org.example.entity.BookingEntity;
import org.example.entity.GuestEntity;
import org.example.entity.RoomEntity;
import org.example.repository.BookingRepository;
import org.example.repository.GuestRepository;
import org.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private GuestRepository guestRepository;

    public void makeBooking(BookingEntity entity) {
        bookingRepository.makeBooking(entity);
    }

    public void getList() {
        List<BookingEntity> list = bookingRepository.getList();
        list.forEach(System.out::println);
    }

    public void getListByRoom(Integer roomId) {
        RoomEntity room = roomRepository.getById(roomId);
        if (room == null) {
            System.out.println("not fount room");
            return;
        }
        List<BookingEntity> list = bookingRepository.getListByRoom(room);
        list.forEach(System.out::println);
    }

    public void getListByGuest(Integer guestId) {
        GuestEntity guest = guestRepository.getById(guestId);
        if (guest==null){
            System.out.println("not fount guest");
            return;
        }
        List<BookingEntity> list=bookingRepository.getListByGuest(guest);
        list.forEach(System.out::println);
    }
}
