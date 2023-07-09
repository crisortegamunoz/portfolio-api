package com.cristianortega.portfolio.persistence.repository;

import com.cristianortega.portfolio.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

}
