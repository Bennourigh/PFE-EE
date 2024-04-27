package org.mgb.orderservice.repository;

import org.mgb.orderservice.entities.Client;
import org.mgb.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    @Query("SELECT c.orders FROM Client c WHERE c.clientId = :clientId")
    Set<Order> findOrders(@Param("clientId") UUID clientId);
}
