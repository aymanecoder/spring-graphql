package com.example.springgraphql.dto;

import lombok.Data;


public record ProductRequestDTO(
        String id,
        String name,
        double price,
        int quantity,
        Long categoryId
) { }
