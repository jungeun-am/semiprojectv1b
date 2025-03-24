package com.example.zzyzzy.semiprojectv1.repository;

import com.example.zzyzzy.semiprojectv1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUserid(String userid);
    boolean existsByEmail(String email);
    Optional<User> findByUserid(String Userid);
}