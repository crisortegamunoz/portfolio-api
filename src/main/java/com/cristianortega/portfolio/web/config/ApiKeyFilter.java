package com.cristianortega.portfolio.web.config;

import com.cristianortega.portfolio.service.security.ApiKeyService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {

    private static final String API_KEY_CODE = "x-api-key";
    private List<String> ALLOWED_API_KEYS = new ArrayList<>(0);
    private final ApiKeyService apiKeyService;

    public ApiKeyFilter(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String apiKey = request.getHeader(API_KEY_CODE);
        if (!request.getMethod().equals(HttpMethod.GET.toString())) {
            chain.doFilter(request, response);
            return;
        }

        if (apiKey == null || apiKey.isBlank()) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }

        Authentication authentication = getAuthentication(apiKey);
        if (authentication != null) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
            return;
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }

    private Authentication getAuthentication(String apiKey) {
        if (ALLOWED_API_KEYS.isEmpty()) {
            ALLOWED_API_KEYS = this.apiKeyService.getAllCodes();
        }

        for (String validApiKey : ALLOWED_API_KEYS) {
            if (apiKey.equals(validApiKey)) {
                return new UsernamePasswordAuthenticationToken(validApiKey, null, Collections.emptyList());
            }
        }
        return null;
    }

}
