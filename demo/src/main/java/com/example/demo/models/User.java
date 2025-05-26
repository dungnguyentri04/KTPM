package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    public enum UserRole{
        ACCOUNTANT,
        MANAGER
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "createdUserId", cascade = CascadeType.ALL)
    private List<Demographics> demographicsCreated;

    @OneToMany(mappedBy = "deletedUserId", cascade = CascadeType.ALL)
    private List<Demographics> demographicsDeleted;

    @Column(unique = true)
    private String userName;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String phoneNumber;

    private LocalDate created_at;

    private LocalDate updated_at;

}
