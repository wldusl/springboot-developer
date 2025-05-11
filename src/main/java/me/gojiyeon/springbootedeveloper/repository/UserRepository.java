package me.gojiyeon.springbootedeveloper.repository;

import me.gojiyeon.springbootedeveloper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);  //email로 사용자 정보 가져옴
}
