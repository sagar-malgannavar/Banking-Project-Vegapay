package com.example.banking.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LimitOffer extends Account{

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "account_id",
            referencedColumnName ="accountId"
    )
    private Account account;

    @Value("${my.list.values}")
    private List<String> limitType;

    //the condition is it should be greater than the current limit but where to fetch from current limit
    private int newLimit;

    private Date offerActivationTime;

    @Future
    private Date offerExpiryTime;

    @Value("PENDING")
    private String status;
}
