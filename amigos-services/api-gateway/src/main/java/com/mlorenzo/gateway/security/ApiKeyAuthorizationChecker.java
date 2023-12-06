package com.mlorenzo.gateway.security;

public interface ApiKeyAuthorizationChecker {
    boolean isAuthorized(String api, String routeId);
}
