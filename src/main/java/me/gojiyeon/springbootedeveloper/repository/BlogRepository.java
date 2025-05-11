package me.gojiyeon.springbootedeveloper.repository;

import me.gojiyeon.springbootedeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
