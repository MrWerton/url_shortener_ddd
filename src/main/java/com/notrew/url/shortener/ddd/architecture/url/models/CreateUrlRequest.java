package com.notrew.url.shortener.ddd.architecture.url.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateUrlRequest(
        @JsonProperty("original_url") String originalUrl,
        @JsonProperty("short_url") String shortUrl
) {
}
