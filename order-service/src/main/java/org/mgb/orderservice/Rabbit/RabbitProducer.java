package org.mgb.orderservice.Rabbit;


import org.mgb.orderservice.DTOs.UpdateProductReservedDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitProducer {
    @Value("${Rabbitmq.exchange.name}")
    private String exchange ;
    @Value("${Rabbitmq.routing.key}")
    private String routingKey ;
    private final RabbitTemplate rabbitTemplate ;
    public RabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void send(UpdateProductReservedDTO updateProductReservedDTO){
        rabbitTemplate.convertAndSend(exchange,routingKey,updateProductReservedDTO);
    }

}
