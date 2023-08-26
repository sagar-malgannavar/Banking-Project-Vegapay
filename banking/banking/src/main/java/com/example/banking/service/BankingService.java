package com.example.banking.service;

import com.example.banking.entity.Account;
import com.example.banking.entity.LimitOffer;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface BankingService {

    public Account createAccount(Account account);

    List<Account> getAccounts();

    LimitOffer createLimitOffer(LimitOffer limitOffer);

    List<LimitOffer> getActiveLimitOffers(long accountId, Date activeDate);

    LimitOffer updateLimitOfferStatus(long limitOfferId, String status);
}
