package com.mlorenzo.fraudcheck;

import com.mlorenzo.clients.fraudcheck.FraudCheckRequest;
import com.mlorenzo.clients.fraudcheck.FraudCheckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class FraudCheckServiceImpl implements FraudCheckService{
    private final FraudCheckRepository repository;

    @Override
    public FraudCheckResponse checkIsFraudster(FraudCheckRequest request) {
        FraudCheck fraudCheckHistory = FraudCheck.builder()
                .customerId(request.customerId())
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build();
        repository.save(fraudCheckHistory);
        return new FraudCheckResponse(false);
    }

}
