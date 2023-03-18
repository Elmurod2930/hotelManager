package org.example.controller;

import org.example.util.ScannerUtil;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
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
    }

    public void list() {
    }

    public void listByRoom() {
    }

    public void listByGuest() {
    }
}
