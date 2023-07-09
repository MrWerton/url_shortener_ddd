package com.notrew.url.shortener.ddd.architecture.url.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateUrlRequest(
        @JsonProperty("url") String originalUrl
) {
}
