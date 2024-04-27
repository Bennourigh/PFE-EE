package org.mgb.inventoryservice.mappers;

import org.mgb.inventoryservice.DTOs.ProductAvailableDTO;
import org.mgb.inventoryservice.DTOs.ProductDTO;
import org.mgb.inventoryservice.DTOs.ProductReservedDTO;
import org.mgb.inventoryservice.entities.Product;
import org.mgb.inventoryservice.entities.ProductAvailable;
import org.mgb.inventoryservice.entities.ProductReserved;

public interface ProductMapper {
    ProductDTO fromProduct(Product product);

    Product fromProductDTO(ProductDTO productDTO);

    ProductReservedDTO fromProductReserved(ProductReserved product);

    ProductReserved fromProductReservedDTO(ProductReservedDTO productDTO);

    ProductAvailableDTO fromProductAvailable(ProductAvailable product);

    ProductAvailable fromProductAvailableDTO(ProductAvailableDTO productDTO);
}
