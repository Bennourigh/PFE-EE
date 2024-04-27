package org.mgb.orderservice.web;

import lombok.extern.slf4j.Slf4j;
import org.mgb.orderservice.DTOs.*;


import org.mgb.orderservice.enums.OrderStatus;
import org.mgb.orderservice.services.ClientServiceImpl;
import org.mgb.orderservice.services.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController@Slf4j @CrossOrigin("*")@RequestMapping("/api")
public class OrderRestController {
    private final OrderServiceImpl orderService;

    private final ClientServiceImpl clientService;

    public OrderRestController(OrderServiceImpl orderService, ClientServiceImpl clientService) {
        this.orderService = orderService;

        this.clientService = clientService;
    }
    @GetMapping("/orders/{id}")
    public OrderDTO getOrder(@PathVariable UUID id){
        return orderService.getOrderById(id);
    }
    @GetMapping("/orders")
    public List<OrderDTO> listOrders(){
        return orderService.getOrders();
    }
    @PostMapping("/orders")
    public OrderDTO addOrder(OrderDTO orderDTO){
        return orderService.addOrder(orderDTO);
    }
    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable UUID id){
        orderService.deleteOrder(id);
    }
    @PutMapping("/orders/update")
    public void updateOrderStatus(@RequestBody OrderDTO orderDTO){
         orderService.updateOrder(orderDTO);
    }
    @DeleteMapping("/orderItems/{cartItemId}")
    public void deleteOrderItem(@PathVariable UUID cartItemId){
        orderService.deleteOrderItem(cartItemId);
    }
    @PutMapping("/orders/items/update")
    public ResponseEntity<Void> updateQuantity(@RequestBody CartItemDTO cartItemDTO ) {
        orderService.updateOrderItem(cartItemDTO);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/clients/{clientId}")
    public ClientDTO getClient(@PathVariable UUID clientId){
        return clientService.getClientById(clientId);
    }
    @GetMapping("/clients")
    public List<ClientDTO> getClients(){
        return clientService.getAllClients();
    }
    @GetMapping("/clients/order/{clientId}")
    public Set<OrderDTO> getOrdersOfClient(@PathVariable UUID clientId){

        return clientService.getAllOrdersClient(clientId);
    }
    @PutMapping("/clients/update")
    public void updateClient(ClientDTO clientDTO){
        clientService.updateClient(clientDTO);
    }
    @DeleteMapping("/clients/{clientId}")
    public void deleteClient(@PathVariable UUID clientId){
        clientService.deleteClient(clientId);
    }

    @PostMapping("/clients")
    public void createClient(ClientDTO clientDTO){
        clientService.createClient(clientDTO);
    }
}