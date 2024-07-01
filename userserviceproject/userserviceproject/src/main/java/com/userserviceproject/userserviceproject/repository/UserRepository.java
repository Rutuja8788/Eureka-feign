package com.userserviceproject.userserviceproject.repository;


import com.userserviceproject.userserviceproject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
{
    User findByEmail(String email);
}
