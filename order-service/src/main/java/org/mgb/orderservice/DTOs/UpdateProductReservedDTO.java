package org.mgb.orderservice.DTOs;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data @RequiredArgsConstructor
public class UpdateProductReservedDTO {
    private Long id;
    private double price;
    private int quantity;

}
