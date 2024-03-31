package com.skn.inventario.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    private String code;

    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "idBranch")
    private Branch branch;

    private String description;

    private String serial;

    @ManyToOne
    @JoinColumn(name = "idLocation")
    private Location location;

    private Long initialStock;
}
