package com.skn.inventario.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBrand;
    private String name;
    private String description;
}
