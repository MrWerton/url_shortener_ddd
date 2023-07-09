package com.notrew.url.shortener.ddd.domain.url;

import com.notrew.url.shortener.ddd.domain.shared.AggregateRoot;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Url extends AggregateRoot<UrlID> {

    private final String originalUrl;
    private final String shortUrl;
    private final Instant createdAt;
    private final Instant updatedAt;
    private final Instant expireAt;
    protected Url(UrlID urlID,  String originalUrl,
     String shortUrl,
     Instant createdAt,
     Instant updatedAt,
     Instant expireAt
    ) {
        super(urlID);
        this.originalUrl = Objects.requireNonNull(originalUrl,"original url should not be null" );
        this.shortUrl = Objects.requireNonNull(shortUrl,"short url should not be null" );
        this.createdAt = createdAt;
        this.updatedAt =updatedAt;
        this.expireAt = expireAt;
    }

    public static Url create(
            String originalUrl,
            String shortUrl
    ) {
        final var ID = UrlID.unique();
        final var NOW = Instant.now();
        return new Url(ID, originalUrl, shortUrl,NOW, NOW, NOW.plus(7, ChronoUnit.DAYS));
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public Instant getExpireAt() {
        return expireAt;
    }
}
