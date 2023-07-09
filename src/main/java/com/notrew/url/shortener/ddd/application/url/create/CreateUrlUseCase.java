package com.notrew.url.shortener.ddd.application.url.create;

import com.notrew.url.shortener.ddd.application.shared.usecases.InputUseCase;
import com.notrew.url.shortener.ddd.application.url.create.dto.UrlDTO;
import com.notrew.url.shortener.ddd.domain.url.entities.Url;
import com.notrew.url.shortener.ddd.domain.url.gateways.UrlGateway;

public class CreateUrlUseCase extends InputUseCase<UrlDTO> {
    private final UrlGateway urlGateway;

    public CreateUrlUseCase(final UrlGateway urlGateway) {
        this.urlGateway = urlGateway;
    }

    @Override
    public void execute(UrlDTO data) {
        final var url = Url.create(data.url(), data.shortUrl());
        urlGateway.create(url);
    }
}
