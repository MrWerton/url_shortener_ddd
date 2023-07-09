package com.notrew.url.shortener.ddd.application.url.create.dto;

public record UrlResponse(String url, String shorUrl) {

    public static UrlResponse from(String url, String shortUrl) {
        return new UrlResponse(url, shortUrl);
    }
}
