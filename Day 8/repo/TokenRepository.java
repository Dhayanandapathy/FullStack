package com.java.agrofund.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.agrofund.model.Token;
import java.util.List;


public interface TokenRepository extends JpaRepository<Token, Long>{
    List<Token> findAllByUser_IdAndRevokedFalseAndExpiredFalse(Long id);

    Optional<Token> findByToken(String token);
    
}
