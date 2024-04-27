package org.mgb.inventoryservice.services;


import org.mgb.inventoryservice.DTOs.ProductDTO;


import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProduct(UUID productId);
    void addProduct(ProductDTO productDTO);
    void updateProduct(ProductDTO productDTO);
    void deleteProduct(UUID productId);
}
