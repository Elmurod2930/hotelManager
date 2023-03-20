package org.example.controller;

import org.example.entity.GuestEntity;
import org.example.entity.PassportEntity;
import org.example.service.GuestService;
import org.example.service.PassportService;
import org.example.util.ScannerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Date;

@Controller
public class GuestController {
    @Autowired
    private GuestService guestService;
    @Autowired
    private PassportService passportService;

    public void menu() {
        boolean b = true;
        while (b) {
            System.out.println("1 => Add\n2 => List\n0 => Exit");
            System.out.print("Enter action: ");
            int action = ScannerUtil.scannerInt.nextInt();
            switch (action) {
                case 0:
                    b = false;
                    break;
                case 1:
                    add();
                    break;
                case 2:
                    list();
                    break;

            }
        }
    }

    public void add() {
        System.out.print("Enter name: ");
        String name = ScannerUtil.scannerText.next();
        System.out.print("Enter surname: ");
        String surname = ScannerUtil.scannerText.next();
        System.out.print("Enter phone: ");
        String phone = ScannerUtil.scannerText.next();
        System.out.print("Enter passport number: ");
        String number = ScannerUtil.scannerText.next();
        System.out.print("Enter passport given date: ");
        Date givenDate = Date.valueOf(ScannerUtil.scannerText.next());
        System.out.print("Enter passport expired date: ");
        Date expiredDate = Date.valueOf(ScannerUtil.scannerText.next());
        System.out.print("Enter passport  given by: ");
        String givenBy = ScannerUtil.scannerText.next();

        PassportEntity passport = new PassportEntity(number, givenDate, expiredDate, givenBy);
        passportService.add(passport);
        GuestEntity entity = new GuestEntity(name, surname, phone, passport);
        guestService.add(entity);
    }

    public void list() {
        guestService.getList();
    }

}
