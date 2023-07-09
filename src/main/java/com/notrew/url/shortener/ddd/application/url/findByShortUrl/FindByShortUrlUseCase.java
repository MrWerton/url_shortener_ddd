package com.notrew.url.shortener.ddd.application.url.findByShortUrl;

import com.notrew.url.shortener.ddd.application.shared.usecases.UseCase;
import com.notrew.url.shortener.ddd.domain.url.gateways.UrlGateway;

public class FindByShortUrlUseCase extends UseCase<String, UrlOutput> {
    private final UrlGateway urlGateway;

    public FindByShortUrlUseCase(final UrlGateway urlGateway) {
        this.urlGateway = urlGateway;
    }

    @Override
    public UrlOutput execute(String data) {


        return this.urlGateway.findByShortUrl(data)
                .map(UrlOutput::from)
                .orElseThrow();
    }


}
