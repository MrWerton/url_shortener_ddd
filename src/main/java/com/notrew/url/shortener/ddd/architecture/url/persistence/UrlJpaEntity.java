package com.notrew.url.shortener.ddd.architecture.url.persistence;


import com.notrew.url.shortener.ddd.domain.url.entities.Url;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "url")
@AllArgsConstructor
@Data
@Getter
@NoArgsConstructor

public class UrlJpaEntity {

    @Id
    @Column(nullable = false)

    private String id;

    @Column(nullable = false)
    private String originalUrl;
    @Column(nullable = false)
    private String shortUrl;

    @Column(name = "created_at", nullable = false, columnDefinition = "timestamp(6)")
    private Instant createdAt;
    @Column(name = "updated_at", nullable = false, columnDefinition = "timestamp(6)")
    private Instant updatedAt;
    @Column(name = "expire_at", nullable = false, columnDefinition = "timestamp(6)")
    private Instant expireAt;


    public static UrlJpaEntity from(final Url url) {
        return new UrlJpaEntity(url.getID().getValue(), url.getOriginalUrl(), url.getShortUrl(), url.getCreatedAt(), url.getUpdatedAt(), url.getExpireAt());
    }

    public Url toAgregate() {
        return Url.create(getOriginalUrl());
    }
}
