package org.mgb.inventoryservice.Rabbit;

import org.mgb.inventoryservice.DTOs.UpdateProductReservedDTO;
import org.mgb.inventoryservice.entities.Product;
import org.mgb.inventoryservice.entities.ProductReserved;
import org.mgb.inventoryservice.repo.ProductRepository;
import org.mgb.inventoryservice.repo.ProductReservedRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class RabbitConsumer {
    private final ProductReservedRepository productReservedRepository;
    private final ProductRepository productRepository;

    public RabbitConsumer(ProductReservedRepository productReservedRepository, ProductRepository productRepository) {
        this.productReservedRepository = productReservedRepository;
        this.productRepository = productRepository;
    }

    @RabbitListener(queues = {"${Rabbitmq.queue.name}"})
    public void Consume(UpdateProductReservedDTO updateProductReserved){
        Product product = productRepository.findById(updateProductReserved.getId()).get();
        ProductReserved productReserved = new ProductReserved();
        productReserved.setId(updateProductReserved.getId());
        productReserved.setName(product.getName());
        productReserved.setPrice(updateProductReserved.getPrice());
        productReserved.setQuantity(updateProductReserved.getQuantity());
        productReservedRepository.saveAndFlush(productReserved);

    }
}
