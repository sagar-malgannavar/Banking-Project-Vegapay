package com.example.banking.service;

import com.example.banking.entity.Account;
import com.example.banking.entity.LimitOffer;
import com.example.banking.repository.BankingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BankingServiceImpl implements BankingService{

    @Autowired
    private BankingRepository bankingRepository;

    @Override
    public Account createAccount(Account account) {
        return bankingRepository.save(account);
    }

    @Override
    public List<Account> getAccounts() {
        return bankingRepository.findAll();
    }

    @Override
    public LimitOffer createLimitOffer(LimitOffer limitOffer) {
        return bankingRepository.save(limitOffer);
    }

    @Override
    public List<LimitOffer> getActiveLimitOffers(long accountId, Date activeDate) {
        return bankingRepository.getActive(accountId,activeDate);
    }

    @Override
    public LimitOffer updateLimitOfferStatus(long limitOfferId, String status) {
        return bankingRepository.updateOffer(limitOfferId,status);
    }


}
