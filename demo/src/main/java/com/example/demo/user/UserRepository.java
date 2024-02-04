package com.example.demo.user;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);

    User findByActivationToken(String token);

    Page<User> findByIdNot(int id, Pageable pageable);


}
