package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.enums.EmployeeStatus;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private TypeEntity type;

    public EmployeeEntity(String name, String surname, String phone, Date birthday) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.birthday = birthday;
        this.status = EmployeeStatus.ACTIVE;
    }
}
