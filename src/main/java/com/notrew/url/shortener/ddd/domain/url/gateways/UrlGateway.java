package com.notrew.url.shortener.ddd.domain.url.gateways;

import com.notrew.url.shortener.ddd.domain.url.entities.Url;
import com.notrew.url.shortener.ddd.domain.url.entities.UrlID;

import java.util.Optional;

public interface UrlGateway {
    void create(Url url);

    Optional<Url> findById(UrlID id);


}
