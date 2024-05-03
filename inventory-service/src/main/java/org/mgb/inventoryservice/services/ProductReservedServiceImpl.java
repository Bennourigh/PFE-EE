package org.mgb.inventoryservice.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.mgb.inventoryservice.DTOs.ProductReservedDTO;
import org.mgb.inventoryservice.entities.ProductReserved;

import org.mgb.inventoryservice.mappers.ProductMapperImpl;
import org.mgb.inventoryservice.repo.ProductReservedRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProductReservedServiceImpl implements ProductReservedService {
    private final ProductMapperImpl productMapper;
    private final ProductReservedRepository productReservedRepository;

    public ProductReservedServiceImpl(ProductMapperImpl productMapper, ProductReservedRepository productReservedRepository) {
        this.productMapper = productMapper;
        this.productReservedRepository = productReservedRepository;
    }

    @Override
    public List<ProductReservedDTO> getAllReserved() {
        List<ProductReserved> productReservedList = productReservedRepository.findAll();
        return productReservedList.stream()
               .map(productMapper::fromProductReserved)
               .collect(Collectors.toList());
    }

    @Override
    public ProductReservedDTO getProductReserved(UUID productId) {
        ProductReserved productReserved = productReservedRepository.findById(productId).get();
        return productMapper.fromProductReserved(productReserved);
    }

    @Override
    public void updateReserved(ProductReservedDTO requestDTO) {
        ProductReserved productReserved = productReservedRepository.findById(requestDTO.getId()).get();
        productReserved.setQuantity(productReserved.getQuantity()+ requestDTO.getQuantity());
        productReservedRepository.saveAndFlush(productReserved);
    }

    @Override
    public void addReservedDTO(ProductReservedDTO productReservedDTO) {
        ProductReserved productReserved = productMapper.fromProductReservedDTO(productReservedDTO);
        productReservedRepository.saveAndFlush(productReserved);
    }

    @Override
    public void deleteReservedDTO(UUID productId) {
        productReservedRepository.deleteById(productId);
    }

}