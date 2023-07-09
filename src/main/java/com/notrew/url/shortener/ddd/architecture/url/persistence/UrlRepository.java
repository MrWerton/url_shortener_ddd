package com.notrew.url.shortener.ddd.architecture.url.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<UrlJpaEntity, String> {
}
