package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "passport")
public class PassportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "number", unique = true, nullable = false)
    private String number;
    @Column(name = "location")
    private String location;
    @Column(name = "given_date")
    private Date givenDate;
    @Column(name = "effective_date")
    private Date effectiveDate;
    @Column(name = "given_by_whon")
    private String givenByWhon;
}
