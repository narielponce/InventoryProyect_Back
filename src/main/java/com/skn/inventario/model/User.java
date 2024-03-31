package com.skn.inventario.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String name;
    private String password;
}
