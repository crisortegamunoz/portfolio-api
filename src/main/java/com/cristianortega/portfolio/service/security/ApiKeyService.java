package com.cristianortega.portfolio.service.security;

import com.cristianortega.portfolio.persistence.entity.security.ApiKey;
import com.cristianortega.portfolio.persistence.repository.security.ApiKeyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApiKeyService {

    private final ApiKeyRepository apiKeyRepository;

    public ApiKeyService(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    public List<String> getAllCodes() {
        List<String> codes = new ArrayList<>(0);
        this.apiKeyRepository.findAllBy().ifPresent(apiKeys -> {
            codes.addAll(apiKeys.stream().map(ApiKey::getCode).toList());
        });
        return codes;
    }

    public String getApyKeyByUsername(String username) {
        String code = null;
        Optional<ApiKey> apiKeyOptional = this.apiKeyRepository.findByUsernameEquals(username);
        if(apiKeyOptional.isPresent()) {
            code = apiKeyOptional.get().getCode();
        }
        return code;
    }

}
