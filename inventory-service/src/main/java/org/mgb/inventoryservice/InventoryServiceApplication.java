package org.mgb.inventoryservice;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.mgb.inventoryservice.entities.Product;
import org.mgb.inventoryservice.entities.ProductAvailable;
import org.mgb.inventoryservice.entities.ProductReserved;
import org.mgb.inventoryservice.repo.ProductAvailableRepository;
import org.mgb.inventoryservice.repo.ProductRepository;
import org.mgb.inventoryservice.repo.ProductReservedRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableDiscoveryClient

public class InventoryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner startP(ProductRepository productRepository){
        return args -> {

            for (int i = 1; i <8; i++) {
                productRepository.saveAll(List.of(
                        Product.builder()
                                .name("Computer "+i)
                                .price(1200+Math.random()*10000).build()
                ));
            }
        };
    }
    @Bean
    CommandLineRunner startPR(ProductReservedRepository productReservedRepository){
        return args -> {

            for (int i = 1; i <8; i++) {
                productReservedRepository.saveAll(List.of(
                        ProductReserved.builder()
                                .id(UUID.randomUUID())
                                .name("Computer "+i)
                                .price(1200+Math.random()*10000)
                                .quantity(1000)
                                .build()
                ));
            }
        };
    }
    @Bean
    CommandLineRunner startPA(ProductAvailableRepository productAvailableRepository){
        return args -> {

            for (int i = 1; i <8; i++) {
                productAvailableRepository.saveAll(List.of(
                        ProductAvailable.builder()
                                .id(UUID.randomUUID())
                                .name("Computer "+i)
                                .price(1200+Math.random()*10000)
                                .quantity(1000)
                                .build()
                ));
            }
        };
    }
}