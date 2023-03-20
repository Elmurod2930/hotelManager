package org.example.controller;

import org.example.entity.BookingEntity;
import org.example.entity.GuestEntity;
import org.example.entity.RoomEntity;
import org.example.repository.GuestRepository;
import org.example.repository.RoomRepository;
import org.example.service.BookingService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Date;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private RoomRepository roomRepository;

    public void menu() {
        boolean b = true;
        while (b) {
            System.out.println("1 => Make booking\n2 => List\n3 => List by room\n4 => List by guest\n0 => Exit");
            System.out.print("Enter action: ");
            int action = ScannerUtil.scannerInt.nextInt();
            switch (action) {
                case 0:
                    b = false;
                    break;
                case 1:
                    makeBooking();
                    break;
                case 2:
                    list();
                    break;
                case 3:
                    listByRoom();
                    break;
                case 4:
                    listByGuest();
                    break;
            }
        }
    }

    public void makeBooking() {
        System.out.print("Enter guest id: ");
        Integer guestId = ScannerUtil.scannerInt.nextInt();
        System.out.print("Enter room id: ");
        Integer roomId = ScannerUtil.scannerInt.nextInt();
        System.out.print("Enter booking date: ");
        Date bookingDate = Date.valueOf(ScannerUtil.scannerText.next());
        System.out.print("Enter booking day: ");
        Integer bookingDay = ScannerUtil.scannerInt.nextInt();
        RoomEntity room = roomRepository.getById(roomId);
        GuestEntity guest = guestRepository.getById(guestId);
        if (room == null) {
            System.out.println("not fount room");
            return;
        }
        if (guest == null) {
            System.out.println("not fount guest");
            return;
        }
        BookingEntity entity = new BookingEntity(guest, room, bookingDate, bookingDay);
        bookingService.makeBooking(entity);
    }

    public void list() {
        bookingService.getList();
    }

    public void listByRoom() {
        System.out.print("Enter room id: ");
        Integer roomId = ScannerUtil.scannerInt.nextInt();
        bookingService.getListByRoom(roomId);
    }

    public void listByGuest() {
        System.out.print("Enter guest id: ");
        Integer guestId = ScannerUtil.scannerInt.nextInt();
        bookingService.getListByGuest(guestId);
    }
}
