package com.gokhantamkoc.javabootcamp.odevhafta45.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private long id;
    private String name;
    private String description;

    public String toString() {
        return String.format("%d %s", this.id, this.name);
    }
}
