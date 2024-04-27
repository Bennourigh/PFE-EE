package org.mgb.inventoryservice.mappers;


import org.mgb.inventoryservice.DTOs.ProductAvailableDTO;
import org.mgb.inventoryservice.DTOs.ProductDTO;
import org.mgb.inventoryservice.DTOs.ProductReservedDTO;
import org.mgb.inventoryservice.entities.Product;
import org.mgb.inventoryservice.entities.ProductAvailable;
import org.mgb.inventoryservice.entities.ProductReserved;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductMapperImpl implements ProductMapper {
   @Override
   public ProductDTO fromProduct(Product product){
      ProductDTO productDTO = new ProductDTO();
      BeanUtils.copyProperties(product, productDTO);
      return productDTO;
   }
   @Override
   public Product fromProductDTO(ProductDTO productDTO){
      Product product = new Product();
      BeanUtils.copyProperties(productDTO, product);
      return product;
   }
   @Override
   public ProductReservedDTO fromProductReserved(ProductReserved product){
      ProductReservedDTO productDTO = new ProductReservedDTO();
      BeanUtils.copyProperties(product, productDTO);
      return productDTO;
   }
   @Override
   public ProductReserved fromProductReservedDTO(ProductReservedDTO productDTO){
      ProductReserved product = new ProductReserved();
      BeanUtils.copyProperties(productDTO, product);
      return product;
   }
   @Override
   public ProductAvailableDTO fromProductAvailable(ProductAvailable product){
      ProductAvailableDTO productDTO = new ProductAvailableDTO();
      BeanUtils.copyProperties(product, productDTO);
      return productDTO;
   }@Override
   public ProductAvailable fromProductAvailableDTO(ProductAvailableDTO productDTO){
      ProductAvailable product = new ProductAvailable();
      BeanUtils.copyProperties(productDTO, product);
      return product;
   }
}