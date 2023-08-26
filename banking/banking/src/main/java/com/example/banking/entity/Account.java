package com.example.banking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id",
    nullable = false,
    foreignKey = @ForeignKey(name = "FK_CUSTOMER"))
    private Customer customer;

    private double accountLimit;
    private double perTransactionLimit;
    private double lastAccountLimit;
    private double lastPerTransactionLimit;
    private Date accountLimitUpdateTime;
    private Date perTransactionLimitUpdateTime;

}
