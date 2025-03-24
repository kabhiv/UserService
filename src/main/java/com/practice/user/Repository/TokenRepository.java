package com.practice.user.Repository;

import com.practice.user.Models.Token;
import com.practice.user.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findByUser(User userId);

    Optional<Token> findByValueAndDeletedAndExpiringAtGreaterThan(String value, Boolean deleted, Date expiringAt);

}
