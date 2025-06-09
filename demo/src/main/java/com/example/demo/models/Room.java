package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "room")
public class Room {
    public enum RoomStatus{
        EMPTY, OCCUPIED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private RoomStatus roomStatus;

    private String description;

    private Float area;

    private String location;

    private Long householdId;

    private String ownerName;

    private LocalDate createdAt;

    private LocalDate updatedAt;

}
