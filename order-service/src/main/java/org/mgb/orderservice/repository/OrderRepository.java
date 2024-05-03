package org.mgb.orderservice.repository;

import org.mgb.orderservice.entities.CartItem;
import org.mgb.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



import java.util.UUID;
import java.util.*;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query("SELECT ci FROM CartItem ci JOIN ci.order o WHERE o.orderId = :orderId")
    List<CartItem> findOrderItems(@Param("orderId") UUID orderId);


}