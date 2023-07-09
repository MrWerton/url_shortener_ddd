package com.notrew.url.shortener.ddd.application.url.create.dto;

public record UrlDTO(String url, String shortUrl) {

    public static UrlDTO with(String url, String shortUrl) {
        return new UrlDTO(url, shortUrl);
    }
}
