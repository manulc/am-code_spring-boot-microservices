package com.mlorenzo.fraudcheck;

import com.mlorenzo.clients.fraudcheck.FraudCheckRequest;
import com.mlorenzo.clients.fraudcheck.FraudCheckResponse;

public interface FraudCheckService {
    FraudCheckResponse checkIsFraudster(FraudCheckRequest request);
}
