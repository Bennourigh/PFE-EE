package org.mgb.orderservice.entities;

import jakarta.persistence.*;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Entity @Data @RequiredArgsConstructor
@Table(name = "cart_item")
public class CartItem {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long cartItemId;
   private String name;
   private double price;
   private int quantity;

}