package org.mgb.inventoryservice.web;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mgb.inventoryservice.DTOs.*;


import org.mgb.inventoryservice.services.ProductAvailableService;
import org.mgb.inventoryservice.services.ProductReservedService;
import org.mgb.inventoryservice.services.ProductService;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductRestController {

    private ProductService productService;
    private ProductReservedService productReservedService;
    private ProductAvailableService productAvailableService;
    @GetMapping("/getAll")
    public List<ProductDTO> listProducts() {
        return productService.getAllProducts();
    }
    @GetMapping("/{productId}")
    public ProductDTO getProduct(@PathVariable UUID productId) {
        return productService.getProduct(productId);
    }
    @PostMapping("/newProduct")
    public void addProduct(@RequestBody ProductDTO productDTO){
         productService.addProduct(productDTO);
    }
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable UUID productId) {
        productService.deleteProduct(productId);
    }
    @PutMapping("/update")
    public void updateProduct(@RequestBody ProductDTO productDTO) {
        productService.updateProduct(productDTO);
    }
    @GetMapping("/productsAvailable")
    public List<ProductAvailableDTO> listAvailableProducts() {
        return productAvailableService.getAvailableDTOs();
    }
    @PostMapping("/productsAvailable")
    public void addAvailableProduct(@RequestBody ProductAvailableDTO productAvailableDTO) {
        productAvailableService.addAvailableDTO(productAvailableDTO);
    }
    @GetMapping("/productAvailable/{productId}")
    public ProductAvailableDTO getAvailableProduct(@PathVariable UUID productId) {
        return productAvailableService.getAvailable(productId);
    }
    @PutMapping("/productAvailable/update")
    public void updateAvailableProduct(@RequestBody ProductAvailableDTO productAvailableDTO) {
        productAvailableService.updateAvailableDTO(productAvailableDTO);
    }
    @DeleteMapping("/productAvailable/{productId}")
    public void deleteAvailableProduct(@PathVariable UUID productId) {
        productAvailableService.deleteAvailableDTO(productId);
    }
    @GetMapping("/productsReserved")
    public List<ProductReservedDTO> listReservedProducts() {
        return productReservedService.getAllReserved();
    }
    @GetMapping("/productReserved/{productId}")
    public ProductReservedDTO getReservedProduct(@PathVariable UUID productId) {
        return productReservedService.getProductReserved(productId);
    }

    @PostMapping("/productReserved")
    public void addReservedProduct(@RequestBody ProductReservedDTO productReservedDTO) {
        productReservedService.addReservedDTO(productReservedDTO);
    }
    @PostMapping("/productReserved/update")
    public void updateReservedProduct(@RequestBody ProductReservedDTO productReservedDTO) {
        productReservedService.updateReserved(productReservedDTO);
    }
    @DeleteMapping("/{productReservedId}")
    public void deleteReservedProduct(@PathVariable UUID productReservedId) {
        productReservedService.deleteReservedDTO(productReservedId);
    }
}
