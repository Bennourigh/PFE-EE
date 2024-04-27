package org.mgb.orderservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mgb.orderservice.DTOs.ClientDTO;
import org.mgb.orderservice.entities.Client;

@Mapper
public interface ClientMapper {
   ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

   Client clientMapper(ClientDTO clientDTO);
   ClientDTO clientMapper(Client client);
}
