package org.mgb.orderservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mgb.orderservice.DTOs.ClientDTO;
import org.mgb.orderservice.DTOs.OrderCompleteDTO;
import org.mgb.orderservice.entities.Client;
import org.mgb.orderservice.entities.Order;

@Mapper
public interface ClientMapper {
   ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

   Client clientMapper(ClientDTO clientDTO);
   ClientDTO clientMapper(Client client);
   OrderCompleteDTO clientMapper(Order completeOrder);
   Order clientMapper(OrderCompleteDTO completeOrder);
}
