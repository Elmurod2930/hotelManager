package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "guest")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id")
    private GuestEntity guest;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private RoomEntity room;
    @Column(name = "booking_date")
    private Date bookingDate;
    @Column(name = "booking_day")
    private Integer bookingDay;
    @Column(name = "price")
    private Double price;

    public BookingEntity(GuestEntity guest, RoomEntity room, Date bookingDate, Integer bookingDay) {
        this.guest = guest;
        this.room = room;
        this.bookingDate = bookingDate;
        this.bookingDay = bookingDay;
    }
}
