package org.mgb.inventoryservice.services;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.mgb.inventoryservice.DTOs.ProductAvailableDTO;
import org.mgb.inventoryservice.entities.ProductAvailable;
import org.mgb.inventoryservice.mappers.ProductMapper;
import org.mgb.inventoryservice.mappers.ProductMapperImpl;
import org.mgb.inventoryservice.repo.ProductAvailableRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductAvailableServiceImpl implements ProductAvailableService {

    private final ProductMapper productMapper;
    private final ProductAvailableRepository productAvailableRepository;

    public ProductAvailableServiceImpl(ProductMapperImpl productMapper,
            ProductAvailableRepository productAvailableRepository) {
        this.productMapper = productMapper;
        this.productAvailableRepository = productAvailableRepository;
    }

    @Override
    public List<ProductAvailableDTO> getAvailableDTOs() {
        List<ProductAvailable> productAvailableList = productAvailableRepository.findAll();
        return productAvailableList.stream()
               .map(productMapper::fromProductAvailable)
               .collect(Collectors.toList());
    }


    @Override
    public ProductAvailableDTO getAvailable(UUID productId) throws RuntimeException {
        ProductAvailable productAvailable = productAvailableRepository.findById(productId).get();
        return productMapper.fromProductAvailable(productAvailable);
    }

    @Override
    public void updateAvailableDTO(ProductAvailableDTO requestDTO) {
        ProductAvailable productAvailable = productAvailableRepository.findById(requestDTO.getId()).get();
        productAvailable.setQuantity(productAvailable.getQuantity() + requestDTO.getQuantity());
        productAvailableRepository.save(productAvailable);
    }

    @Override
    public void addAvailableDTO(ProductAvailableDTO productAvailableDTO) {
        ProductAvailable productAvailable = productMapper.fromProductAvailableDTO(productAvailableDTO);
        productAvailableRepository.save(productAvailable);
    }

    @Override
    public void deleteAvailableDTO(UUID productId) {
        productAvailableRepository.deleteById(productId);
    }

}