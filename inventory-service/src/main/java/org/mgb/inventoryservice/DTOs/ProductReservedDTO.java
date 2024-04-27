package org.mgb.inventoryservice.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Data
public class ProductReservedDTO {
    private UUID id;
    private String name;
    private double price;
    private int quantity;
}
