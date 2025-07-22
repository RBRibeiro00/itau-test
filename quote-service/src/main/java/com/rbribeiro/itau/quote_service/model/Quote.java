package com.rbribeiro.itau.quote_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "quote")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "asset_code", nullable = false)
    private String assetCode;

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;
}
