package org.mgb.inventoryservice.services;

import org.mgb.inventoryservice.DTOs.ProductAvailableDTO;


import java.util.List;
import java.util.UUID;

public interface ProductAvailableService{
    List<ProductAvailableDTO> getAvailableDTOs();
    ProductAvailableDTO getAvailable(UUID productId);
   void updateAvailableDTO(ProductAvailableDTO requestDTO);

    void addAvailableDTO(ProductAvailableDTO productAvailableDTO);
    void deleteAvailableDTO(UUID productId);

}
