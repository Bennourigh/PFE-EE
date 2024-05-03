package org.mgb.orderservice.services;

import org.mgb.orderservice.DTOs.ClientDTO;
import org.mgb.orderservice.DTOs.OrderCompleteDTO;
import org.mgb.orderservice.DTOs.OrderDTO;
import org.mgb.orderservice.entities.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public interface ClientService {
    @Transactional
    void createClient(ClientDTO clientDTO);

    void addOrder(UUID clientId, OrderCompleteDTO orderDTO);

    @Transactional
    ClientDTO getClientById(UUID id);
    @Transactional
    List<ClientDTO> getAllClients();
    @Transactional
    Set<OrderDTO> getAllOrdersClient(UUID clientId);
    @Transactional
    void updateClient(ClientDTO clientDTO);
    @Transactional
    void deleteClient(UUID id);
}
