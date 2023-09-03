package com.cristianortega.portfolio.persistence.repository;

import com.cristianortega.portfolio.persistence.entity.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiKeyRepository  extends JpaRepository<ApiKey, Integer> {

    ApiKey findByCode(String code);

}
