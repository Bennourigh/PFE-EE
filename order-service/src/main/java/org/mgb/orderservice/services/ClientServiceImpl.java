package org.mgb.orderservice.services;

import org.mgb.orderservice.DTOs.ClientDTO;
import org.mgb.orderservice.DTOs.OrderCompleteDTO;
import org.mgb.orderservice.DTOs.OrderDTO;
import org.mgb.orderservice.entities.Client;
import org.mgb.orderservice.entities.Order;
import org.mgb.orderservice.mappers.ClientMapper;
import org.mgb.orderservice.mappers.OrderMapper;
import org.mgb.orderservice.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }
    @Override
    public void createClient(ClientDTO clientDTO) {
        Client client= ClientMapper.INSTANCE.clientMapper(clientDTO);
        clientRepository.saveAndFlush(client);
    }

    @Override
    public void addOrder(UUID clientId, OrderCompleteDTO orderDTO) {
        Client client = clientRepository.findById(clientId).get();
        //handel exception
        Order order = ClientMapper.INSTANCE.clientMapper(orderDTO);
        Set<Order> orders = clientRepository.findOrders(clientId);
        orders.add(order);
        clientRepository.saveAndFlush(client);

    }
    @Override
    public ClientDTO getClientById(UUID clientId) {
        Client client =clientRepository.findById(clientId).get();
        //handel exception
        return ClientMapper.INSTANCE.clientMapper(client);
    }

    @Override
    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(ClientMapper.INSTANCE::clientMapper).collect(Collectors.toList());
    }

    @Override
    public Set<OrderDTO> getAllOrdersClient(UUID clientId) {
        Set<Order> ListOrders = clientRepository.findOrders(clientId);
        return ListOrders.stream().map(OrderMapper.INSTANCE::orderMapper).collect(Collectors.toCollection(HashSet::new));
    }
    @Override
    public void updateClient(ClientDTO clientDTO) {
        Client client= ClientMapper.INSTANCE.clientMapper(clientDTO);
        clientRepository.saveAndFlush(client);
    }



    @Override
    public void deleteClient(UUID clientId) {
        clientRepository.deleteById(clientId);
    }
}
