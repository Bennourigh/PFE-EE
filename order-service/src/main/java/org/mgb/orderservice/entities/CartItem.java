package org.mgb.orderservice.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;


@Entity @Data @RequiredArgsConstructor @AllArgsConstructor@Builder
@Table(name = "cart_item")
public class CartItem {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long cartItemId;
   private UUID productId;
   private String name;
   private double price;
   private int quantity;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "order_id") // This column links CartItem to Order
   private Order order;
}