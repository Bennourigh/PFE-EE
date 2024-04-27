package org.mgb.orderservice.services;

import org.mgb.orderservice.DTOs.ClientDTO;
import org.mgb.orderservice.DTOs.OrderDTO;
import org.mgb.orderservice.entities.Client;
import org.mgb.orderservice.entities.Order;
import org.mgb.orderservice.mappers.ClientMapper;
import org.mgb.orderservice.mappers.OrderMapper;
import org.mgb.orderservice.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
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
        clientRepository.save(client);
    }
    @Override
    public ClientDTO getClientById(UUID clientId) {
        Client client =clientRepository.findById(clientId).get();
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
        clientRepository.save(client);
    }



    @Override
    public void deleteClient(UUID clientId) {
        clientRepository.deleteById(clientId);
    }
}
