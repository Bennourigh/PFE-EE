package org.mgb.orderservice.DTOs;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.mgb.orderservice.enums.OrderStatus;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class UpdateOrderStatusDTO {
    private UUID OrderId;
    private OrderStatus status;
}
