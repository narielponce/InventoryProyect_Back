package com.skn.inventario.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;
    private String name;
}
