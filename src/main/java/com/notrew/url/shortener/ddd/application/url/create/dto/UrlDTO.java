package com.notrew.url.shortener.ddd.application.url.create.dto;

public record UrlDTO(String url) {

    public static UrlDTO with(String url) {
        return new UrlDTO(url);
    }
}
