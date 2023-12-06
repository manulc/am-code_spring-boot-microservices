package com.mlorenzo.gateway.security;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FakeApiKeyAuthorizationChecker implements ApiKeyAuthorizationChecker {
    private final static Map<String, List<String>> keys = Map.of(
            "supersecure", List.of("customer")
    );

    @Override
    public boolean isAuthorized(String api, String routeId) {
        return keys.getOrDefault(api, List.of()).stream()
                .anyMatch(rId -> rId.equals(routeId));
    }
}
