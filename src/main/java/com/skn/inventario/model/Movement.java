package com.skn.inventario.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="movement")
public class Movement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovement;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "idLocationDesde")
    private Location desde;

    @ManyToOne
    @JoinColumn(name = "idLocationHasta")
    private Location hasta;

    private LocalDateTime dateTimetransaction;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;
}
