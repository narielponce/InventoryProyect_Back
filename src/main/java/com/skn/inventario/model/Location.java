package com.skn.inventario.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocation;
    private String name;
    private String description;
}
