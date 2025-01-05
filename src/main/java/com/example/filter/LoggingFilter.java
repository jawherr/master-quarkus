package main.java.com.example.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class LoggingFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext context) throws IOException {
        System.out.println("Request received: " + context.getUriInfo().getPath());
    }
}