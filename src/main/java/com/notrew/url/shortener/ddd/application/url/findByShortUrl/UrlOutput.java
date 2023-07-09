package com.notrew.url.shortener.ddd.application.url.findByShortUrl;

import com.notrew.url.shortener.ddd.domain.url.entities.Url;
import com.notrew.url.shortener.ddd.domain.url.entities.UrlID;

import java.time.Instant;

public record UrlOutput(UrlID id, String originalUrl, String shortUrl, Instant createdAt, Instant updatedAt,
                        Instant expiresAt) {

    public static UrlOutput from(Url url) {
        return new UrlOutput(url.getID(), url.getOriginalUrl(), url.getShortUrl(), url.getCreatedAt(), url.getUpdatedAt(), url.getExpireAt());
    }
}


