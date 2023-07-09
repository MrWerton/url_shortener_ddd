package com.notrew.url.shortener.ddd.architecture.url;


import com.notrew.url.shortener.ddd.architecture.url.persistence.UrlJpaEntity;
import com.notrew.url.shortener.ddd.architecture.url.persistence.UrlRepository;
import com.notrew.url.shortener.ddd.domain.url.entities.Url;
import com.notrew.url.shortener.ddd.domain.url.entities.UrlID;
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
    public void create(Url url) {
        final var toEntity = UrlJpaEntity.from(url);
        urlRepository.save(toEntity);
    }

    @Override
    public Optional<Url> findById(UrlID id) {
        System.out.println(id);
        final var response = urlRepository.findById(id.getValue());
        return response.map(urlJpaEntity -> Url.from(urlJpaEntity.toAgregate()));
    }
}
