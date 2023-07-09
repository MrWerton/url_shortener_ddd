package com.notrew.url.shortener.ddd.application.url.findById;

import com.notrew.url.shortener.ddd.application.shared.usecases.UseCase;
import com.notrew.url.shortener.ddd.domain.url.gateways.UrlGateway;

public class FindByIdUseCase extends UseCase<String, UrlOutput> {
    private final UrlGateway urlGateway;

    public FindByIdUseCase(final UrlGateway urlGateway) {
        this.urlGateway = urlGateway;
    }

    @Override
    public UrlOutput execute(String data) {


        return this.urlGateway.findByShortUrl(data)
                .map(UrlOutput::from)
                .orElseThrow();
    }


}
