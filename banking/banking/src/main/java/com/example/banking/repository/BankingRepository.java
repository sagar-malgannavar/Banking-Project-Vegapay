package com.example.banking.repository;

import com.example.banking.entity.Account;
import com.example.banking.entity.LimitOffer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BankingRepository extends JpaRepository<Account, Long> {

    @Query(value = "select * from LimitOffer where status=PENDING AND offerActivationTime<?2 AND offerExpiryDate>?2" +
            "AND accountId = ?1",
            nativeQuery = true)
    List<LimitOffer> getActive(@Param("accountId") long accountId,
                               @Param("activeDate") Date activeDate);


    @Modifying
    @Transactional
    @Query(
            value = "update LimitOffer set status = ACCEPTED where limitOfferId=?1"
    )
    LimitOffer updateOffer(long limitOfferId, String status);
}
