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
@Table(name = "passport")
public class PassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "number", unique = true, nullable = false)
    private String number;
    @Column(name = "given_date")
    private Date givenDate;
    @Column(name = "expired_date")
    private Date expiredDate;
    @Column(name = "given_by")
    private String givenBy;
    @Column(name = "visible")
    private boolean visible;

    public PassportEntity(String number, Date givenDate, Date expiredDate, String givenBy) {
        this.number = number;
        this.givenDate = givenDate;
        this.expiredDate = expiredDate;
        this.givenBy = givenBy;
        this.visible = true;
    }
}
