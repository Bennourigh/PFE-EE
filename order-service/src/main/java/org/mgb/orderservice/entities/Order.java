package org.mgb.orderservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.hibernate.annotations.CreationTimestamp;
import org.mgb.orderservice.enums.OrderStatus;


import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
 @Builder @ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_id")
    private UUID orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @ToString.Exclude
// This is the join column for the Client
    private Client client;
    @CreationTimestamp
    @Column(nullable = false)
    private Date createdAt;
    private double totalPrice;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @Getter private List<CartItem> OrderItems;
}