package com.gokhantamkoc.javabootcamp.odevhafta45.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderDetail {
    private long id;
    private String status;              // ACCEPTED, ON_THE_WAY, SHIPPED
    private String type;                // REQUEST, BID
    private Order order;
    private Product product;
    private float amount;
    private String amountType;          // piece(s), kg, set(s)

    public String toString() {
        return String.format(
                "%d %s %s %s %s",
                this.id,
                this.status,
                this.type,
                this.order,
                this.product,
                this.amount,
                this.amountType
        );
    }
}
