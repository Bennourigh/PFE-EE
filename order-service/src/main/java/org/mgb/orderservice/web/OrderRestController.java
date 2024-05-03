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
    @GetMapping("/orders/orderComplete/{id}")
    public OrderCompleteDTO getOrder(@PathVariable UUID id){

        return orderService.getOrderById(id);
    }
    @GetMapping("/orders")
    public List<OrderDTO> listOrders(){
        return orderService.getOrders();
    }
    @PostMapping("/orders")
    public void addOrder(UUID clientId,OrderCompleteDTO orderDTO){
        clientService.addOrder(clientId,orderDTO);
    }
    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable UUID id){
        orderService.deleteOrder(id);
    }
    @PutMapping("/orders/update")
    public void updateOrderStatus(@RequestBody UpdateOrderStatusDTO orderDTO){
         orderService.updateStatus(orderDTO);
         // must finnish my business with  my money when state changes
    }
    @DeleteMapping("/orderItems/{cartItemId}")
    public void deleteOrderItem(@PathVariable UUID cartItemId){
        orderService.deleteOrderItem(cartItemId);
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