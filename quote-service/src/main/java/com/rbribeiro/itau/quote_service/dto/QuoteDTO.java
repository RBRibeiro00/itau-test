package com.rbribeiro.itau.quote_service.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuoteDTO {

    private String assetCode;
    private BigDecimal unitPrice;
    private LocalDateTime timestamp;
}

