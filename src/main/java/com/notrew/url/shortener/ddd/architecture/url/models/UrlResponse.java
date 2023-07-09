package com.notrew.url.shortener.ddd.architecture.url.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UrlResponse(@JsonProperty("short_url") String shortUrl, @JsonProperty("original_url") String originalUrl
) {
}
