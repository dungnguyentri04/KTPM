package com.example.demo.repositories;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUserName(String username);

    @Query(value = "SELECT COUNT(*) FROM user", nativeQuery = true)
    public long countTotalUsers();
}
