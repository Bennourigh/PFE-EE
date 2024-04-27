package org.mgb.inventoryservice.services;

import org.mgb.inventoryservice.DTOs.ProductReservedDTO;

import java.util.List;
import java.util.UUID;

public interface ProductReservedService {
    List<ProductReservedDTO> getAllReserved();
    ProductReservedDTO getProductReserved(UUID productId);
    void updateReserved(ProductReservedDTO requestDTO);

    void addReservedDTO(ProductReservedDTO productReservedDTO);
    void deleteReservedDTO(UUID productId);

}
