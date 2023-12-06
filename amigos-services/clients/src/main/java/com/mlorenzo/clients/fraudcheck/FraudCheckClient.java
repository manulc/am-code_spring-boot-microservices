package com.mlorenzo.clients.fraudcheck;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "fraud-check-service", path = "api/v1/fraud-checks")
public interface FraudCheckClient {

    @PostMapping
    FraudCheckResponse checkIsFraudster(FraudCheckRequest request);
}
