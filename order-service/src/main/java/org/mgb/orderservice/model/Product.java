package org.mgb.orderservice.model;

import lombok.Data;

@Data
public  class Product {
    private Long productId;
    private String name;
    private double price;
}