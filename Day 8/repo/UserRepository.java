package com.java.agrofund.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.agrofund.model.UserModel;

@Repository
public interface  UserRepository extends JpaRepository<UserModel, Long> {
    
    Optional<UserModel> findByEmail(String name);
}
