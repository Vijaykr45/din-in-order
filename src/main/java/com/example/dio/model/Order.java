package com.example.dio.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "orders")
public class Order {


    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId ;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "order_at")
    private String orderAt ;

    @Column(name = "total_amount")
    private int totalAmount ;

    @ManyToOne
    private  RestaurantTable restaurantTable ;

    @OneToMany
    private List<CartItem> cartItem ;


}
