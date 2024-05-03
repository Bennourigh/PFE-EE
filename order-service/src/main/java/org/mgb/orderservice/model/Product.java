package org.mgb.orderservice.model;

import lombok.Data;

import java.util.UUID;

@Data
public  class Product {
    private UUID productId;
    private String name;
    private double price;
}