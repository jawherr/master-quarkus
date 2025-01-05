package main.java.com.example.config;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsConfig implements Feature {
    @Override
    public boolean configure(FeatureContext context) {
        // Enable CORS for all endpoints
        context.register(new CorsFilter());
        return true;
    }
}