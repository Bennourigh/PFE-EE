package org.mgb.orderservice.services;

import org.mgb.orderservice.DTOs.UpdateProductAvailableDTO;
import org.mgb.orderservice.DTOs.UpdateProductReservedDTO;
import org.mgb.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@FeignClient(name = "INVENTORY-SERVICES")
public interface InventoryRestClientService {

    @RequestMapping(method = RequestMethod.GET, value = "/api/productReserved/{id}")
    Product productById(@PathVariable("id") Long productId);

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    List<Product> allProducts();
    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/products")
    void updateProductReservedQuantity(@RequestBody UpdateProductReservedDTO updateProductReservedDTO);
    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/products")
    void updateProductAvailableQuantity(@RequestBody UpdateProductAvailableDTO updateProductAvailableDTODTO);
}