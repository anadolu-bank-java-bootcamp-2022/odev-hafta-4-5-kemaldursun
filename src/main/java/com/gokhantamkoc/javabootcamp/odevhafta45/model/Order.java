package com.gokhantamkoc.javabootcamp.odevhafta45.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {

    private long id;
    private String status;              // IN_PROGRESS, COMPLETED, CANCELLED
    private Owner requester;
    private Owner bidder;
    private String requesterAddress;
    private String bidderAddress;

    public String toString() {
        return String.format("%d-%s-%s", this.id, this.requester.getFullName(), this.bidder.getFullName());
    }
}
