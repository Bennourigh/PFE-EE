package org.mgb.orderservice.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data @RequiredArgsConstructor

public class UpdateProductAvailableDTO {
    private UUID id;
    private double price;
    private int quantity;
}
