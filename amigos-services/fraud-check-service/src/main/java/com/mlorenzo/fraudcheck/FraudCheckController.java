package com.mlorenzo.fraudcheck;

import com.mlorenzo.clients.fraudcheck.FraudCheckRequest;
import com.mlorenzo.clients.fraudcheck.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/fraud-checks")
public class FraudCheckController {
    private final FraudCheckService fraudCheckService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public FraudCheckResponse checkIsFraudster(@RequestBody FraudCheckRequest request) {
        log.info("Fraud check request form customer {}", request.customerId());
        return fraudCheckService.checkIsFraudster(request);
    }

}
