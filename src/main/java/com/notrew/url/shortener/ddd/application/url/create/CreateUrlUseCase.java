package com.notrew.url.shortener.ddd.application.url.create;

import com.notrew.url.shortener.ddd.application.shared.usecases.UseCase;
import com.notrew.url.shortener.ddd.application.url.create.dto.UrlDTO;
import com.notrew.url.shortener.ddd.application.url.create.dto.UrlResponse;
import com.notrew.url.shortener.ddd.domain.url.entities.Url;
import com.notrew.url.shortener.ddd.domain.url.gateways.UrlGateway;

public class CreateUrlUseCase extends UseCase<UrlDTO, UrlResponse> {
    private final UrlGateway urlGateway;

    public CreateUrlUseCase(final UrlGateway urlGateway) {
        this.urlGateway = urlGateway;
    }

    @Override
    public UrlResponse execute(UrlDTO data) {
        final var url = Url.create(data.url());
        final var response = urlGateway.create(url);
        return UrlResponse.from(response.getOriginalUrl(), url.getShortUrl());

    }
}
