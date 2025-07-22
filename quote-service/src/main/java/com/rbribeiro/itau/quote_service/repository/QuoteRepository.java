package com.rbribeiro.itau.quote_service.repository;

import com.rbribeiro.itau.quote_service.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, String> {

    boolean existsByAssetCodeAndTimestamp(String assetCode, LocalDateTime timestamp);

    @Query("SELECT q FROM Quote q WHERE q.assetCode = :assetCode ORDER BY q.timestamp DESC")
    List<Quote> findLatestByAssetCode(@Param("assetCode") String assetCode, Pageable pageable);
}

