package org.mgb.orderservice.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data @RequiredArgsConstructor

public class UpdateProductAvailableDTO {
    private Long id;
    private double price;
    private int quantity;


}
