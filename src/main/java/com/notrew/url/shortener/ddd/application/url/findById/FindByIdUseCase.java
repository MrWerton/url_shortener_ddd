package com.notrew.url.shortener.ddd.application.url.findById;

import com.notrew.url.shortener.ddd.application.shared.usecases.UseCase;
import com.notrew.url.shortener.ddd.domain.url.entities.UrlID;
import com.notrew.url.shortener.ddd.domain.url.gateways.UrlGateway;

public class FindByIdUseCase extends UseCase<String, UrlOutput> {
    private final UrlGateway urlGateway;

    public FindByIdUseCase(final UrlGateway urlGateway) {
        this.urlGateway = urlGateway;
    }

    @Override
    public UrlOutput execute(String data) {
        final var id = UrlID.from(data);
        return this.urlGateway.findById(id)
                .map(UrlOutput::from)
                .orElseThrow();
    }


}
