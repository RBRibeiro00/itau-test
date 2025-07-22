package com.rbribeiro.itau.quote_service.service;

import com.rbribeiro.itau.quote_service.dto.QuoteDTO;
import com.rbribeiro.itau.quote_service.model.Quote;
import com.rbribeiro.itau.quote_service.repository.QuoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteRepository quoteRepository;

    public void saveOrUpdateQuote(QuoteDTO dto) {
        if (dto.getAssetCode() == null || dto.getTimestamp() == null || dto.getUnitPrice() == null) {
            throw new IllegalArgumentException("Invalid quote data");
        }

        boolean exists = quoteRepository.existsByAssetCodeAndTimestamp(dto.getAssetCode(), dto.getTimestamp());

        if (!exists) {
            Quote quote = Quote.builder()
                    .assetCode(dto.getAssetCode())
                    .unitPrice(dto.getUnitPrice())
                    .timestamp(dto.getTimestamp())
                    .build();

            quoteRepository.save(quote);
        }
    }
}


