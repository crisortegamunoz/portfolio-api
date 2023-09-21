package com.cristianortega.portfolio.persistence.repository.security;

import com.cristianortega.portfolio.persistence.entity.security.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ApiKeyRepository  extends JpaRepository<ApiKey, Integer> {

    Optional<List<ApiKey>> findAllBy();

    Optional<ApiKey> findByUsernameEquals(String userName);

}
