package org.mgb.inventoryservice.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductReserved {
    @Id
    private UUID id;
    private String name;
    private double price;
    private int quantity;
}
