package org.mgb.inventoryservice.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;


@Data @RequiredArgsConstructor
public class UpdateProductReservedDTO {
    private UUID id;
    private double price;
    private int quantity;

}
