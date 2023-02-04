package com.example.springgraphql.entities;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;
    @ManyToOne
    private Category category;

}
