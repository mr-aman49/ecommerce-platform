package com.auth_service.auth_service.repository;

import com.auth_service.auth_service.model.UserCredential;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialRepository extends MongoRepository<UserCredential, String> {
    Optional<UserCredential> findByEmail(String email);
}