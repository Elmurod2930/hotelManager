package org.example.entity;

import lombok.*;
import org.example.enums.RoomType;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "number")
    private Integer number;
    @Column(name = "folder")
    private Integer folder;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private RoomType type;
    @Column(name = "area")
    private Double area;
    @Column(name = "price")
    private Double price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "convenient_id")
    private ConvenientEntity convenientEntity;
    @Column(name = "visible")
    private boolean visible;

    public RoomEntity(Integer number, Integer folder, RoomType type, Double area, Double price) {
        this.number = number;
        this.folder = folder;
        this.type = type;
        this.area = area;
        this.price = price;
        this.visible = true;
    }
}
