package com.example.dio.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "bill")
public class Bill {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long billed ;

    @Column(name = "generate_at")
    @CreatedDate
    private LocalDateTime generatedAt ;

    @Column(name = "total_payable_amount")
    private double  totalPayableAmount;


    @OneToMany
    public List<Order>  orders ;

}