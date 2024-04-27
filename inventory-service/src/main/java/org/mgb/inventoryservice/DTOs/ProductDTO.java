package org.mgb.inventoryservice.DTOs;

import lombok.*;

import java.util.UUID;


@Data
public class ProductDTO {
    private UUID id;
    private String name;
    private double price;
}
