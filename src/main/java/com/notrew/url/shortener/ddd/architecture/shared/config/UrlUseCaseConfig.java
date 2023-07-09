package com.notrew.url.shortener.ddd.architecture.shared.config;


import com.notrew.url.shortener.ddd.application.url.create.CreateUrlUseCase;
import com.notrew.url.shortener.ddd.application.url.findByShortUrl.FindByShortUrlUseCase;
import com.notrew.url.shortener.ddd.domain.url.gateways.UrlGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlUseCaseConfig {
    private final UrlGateway urlGateway;


    public UrlUseCaseConfig(UrlGateway urlGateway) {
        this.urlGateway = urlGateway;
    }

    @Bean
    public CreateUrlUseCase createCategoryUseCase() {
        return new CreateUrlUseCase(urlGateway);
    }

    @Bean
    public FindByShortUrlUseCase findByIdUseCase() {
        return new FindByShortUrlUseCase(urlGateway);
    }
}
