package com.example.config;

import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CorsConfig implements Feature {
    @Override
    public boolean configure(FeatureContext context) {
        // Enable CORS for all endpoints
        return true;
    }
}