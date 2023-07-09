package com.notrew.url.shortener.ddd.architecture.url.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlJpaEntity, String> {
    Optional<UrlJpaEntity> findByShortUrl(String value);
}
