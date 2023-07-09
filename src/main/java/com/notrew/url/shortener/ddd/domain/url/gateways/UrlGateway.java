package com.notrew.url.shortener.ddd.domain.url.gateways;

import com.notrew.url.shortener.ddd.domain.url.entities.Url;

import java.util.Optional;

public interface UrlGateway {
    Url create(Url url);

    Optional<Url> findByShortUrl(String url);


}
