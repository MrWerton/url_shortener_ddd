package com.notrew.url.shortener.ddd.architecture.url;


import com.notrew.url.shortener.ddd.architecture.url.persistence.UrlJpaEntity;
import com.notrew.url.shortener.ddd.architecture.url.persistence.UrlRepository;
import com.notrew.url.shortener.ddd.domain.url.entities.Url;
import com.notrew.url.shortener.ddd.domain.url.gateways.UrlGateway;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlGatewayImp implements UrlGateway {
    final UrlRepository urlRepository;

    public UrlGatewayImp(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public Url create(Url url) {
        final var toEntity = UrlJpaEntity.from(url);
        final var response = urlRepository.save(toEntity);
        return Url.from(response.toAgregate());

    }


    @Override
    public Optional<Url> findByShortUrl(String url) {
        final var response = urlRepository.findByShortUrl(url);
        return response.map(urlJpaEntity -> Url.from(urlJpaEntity.toAgregate()));
    }
}
