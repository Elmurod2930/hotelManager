package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "guest")
public class GuestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone")
    private String phone;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passport_id")
    private PassportEntity passport;
    @Column(name = "visible")
    private boolean visible;

    public GuestEntity(String name, String surname, String phone, PassportEntity passport) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.passport = passport;
        this.visible = true;
    }
}
