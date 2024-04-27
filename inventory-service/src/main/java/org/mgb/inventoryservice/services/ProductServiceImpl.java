package org.mgb.inventoryservice.services;
import lombok.AllArgsConstructor;
import org.mgb.inventoryservice.DTOs.ProductDTO;
import org.mgb.inventoryservice.entities.Product;

import org.mgb.inventoryservice.mappers.ProductMapper;
import org.mgb.inventoryservice.mappers.ProductMapperImpl;
import org.mgb.inventoryservice.repo.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    ProductMapper productMapper;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::fromProduct).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProduct(UUID productId) {
        Product product = productRepository.findById(productId).get();
        return productMapper.fromProduct(product);
    }

    @Override
    public void addProduct(ProductDTO productDTO) {
        Product product = productMapper.fromProductDTO(productDTO);

        product.setId(UUID.randomUUID());
        productRepository.save(product);
    }

    @Override
    public void updateProduct(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId()).get();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(UUID productId) {
        Product product = productRepository.findById(productId).get();
        productRepository.delete(product);
    }
}
