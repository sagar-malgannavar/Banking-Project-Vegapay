package com.example.banking.controller;

import com.example.banking.entity.Account;
import com.example.banking.entity.LimitOffer;
import com.example.banking.service.BankingService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class BankingController {

    private final Logger LOGGER =
            LoggerFactory.getLogger(BankingController.class);

    @Autowired
    private BankingService bankingService;

    @PostMapping("/createAccount")
    public Account createAccount(@Valid @RequestBody Account account) {
        LOGGER.info("Inside createAccount API");
        return bankingService.createAccount(account);
    }

    @GetMapping("/getAccount")
    public List<Account> getAccount() {
        LOGGER.info("Inside getAccount API");
        return bankingService.getAccounts();
    }

    @PostMapping("/createLimitOffer")
    public LimitOffer createLimitOffer(@Valid @RequestBody LimitOffer limitOffer) {
        LOGGER.info("Inside createLimitOffer API");
        return bankingService.createLimitOffer(limitOffer);
    }

    @GetMapping("/getActiveLimitOffers")
    public List<LimitOffer> getActiveLimitOffers(@RequestParam("accountId") long accountId,
                                                 @RequestParam("activeDate") Date activeDate) {
        LOGGER.info("Inside getActiveLimitOffers API");
        return bankingService.getActiveLimitOffers(accountId,activeDate);
    }

    @PutMapping("/updateLimitOfferStatus")
    public LimitOffer updateLimitOfferStatus(@RequestParam("limitOfferId") long limitOfferId,
                                             @RequestParam("status") String status) throws Exception {
        if (status=="ACCEPTED" || status=="REJECTED") {
            LOGGER.info("Inside updateLimitOfferStatus API");
            return  bankingService.updateLimitOfferStatus(limitOfferId,status);
        }
        else
            throw new Exception();
    }
}
