package org.mgb.orderservice.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data@RequiredArgsConstructor

public class ClientDTO {
    private UUID uuid;
    private String name;
    private String email;
}
