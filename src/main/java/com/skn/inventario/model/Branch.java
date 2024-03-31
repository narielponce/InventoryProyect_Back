package com.skn.inventario.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="branch")
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBranch;
    private String name;
    private String description;
}
