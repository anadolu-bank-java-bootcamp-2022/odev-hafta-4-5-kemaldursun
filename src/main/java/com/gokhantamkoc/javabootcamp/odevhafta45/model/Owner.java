package com.gokhantamkoc.javabootcamp.odevhafta45.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Owner {

    private long id;
    private String fullName;
    private String email;

    public String toString() {
        return String.format("%s:%s", fullName, email);
    }
}
