package org.mgb.orderservice.entities;

import jakarta.persistence.*;
import lombok.*;



import java.util.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity

public class Client {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "client_id")
    private UUID clientId;

    private String name;
    private String email;
    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , orphanRemoval = true)
    private Set<Order> orders;
}