package org.mgb.orderservice.repository;

import org.mgb.orderservice.entities.Client;
import org.mgb.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;


@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, UUID> {



}