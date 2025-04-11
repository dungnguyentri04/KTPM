package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany(mappedBy = "createdUserId")
    private List<Demographics> demographicsCreated;

    @OneToMany(mappedBy = "deletedUserId")
    private List<Demographics> demographicsDeleted;

    private String userName;

    private String password;

    private UserRole role;

}
