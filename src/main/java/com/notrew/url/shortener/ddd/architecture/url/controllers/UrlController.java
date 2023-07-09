package com.notrew.url.shortener.ddd.architecture.url.controllers;

import com.notrew.url.shortener.ddd.application.url.create.CreateUrlUseCase;
import com.notrew.url.shortener.ddd.application.url.create.dto.UrlDTO;
import com.notrew.url.shortener.ddd.application.url.findByShortUrl.FindByShortUrlUseCase;
import com.notrew.url.shortener.ddd.architecture.url.models.CreateUrlRequest;
import com.notrew.url.shortener.ddd.architecture.url.models.UrlResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlController {
    private final CreateUrlUseCase createUrlUseCase;
    private final FindByShortUrlUseCase findByShortUrlUseCase;


    public UrlController(CreateUrlUseCase createUrlUseCase, FindByShortUrlUseCase findByShortUrlUseCase) {
        this.createUrlUseCase = createUrlUseCase;
        this.findByShortUrlUseCase = findByShortUrlUseCase;
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody CreateUrlRequest body) {
        final var url = UrlDTO.with(body.originalUrl());
        final var response = this.createUrlUseCase.execute(url);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/")
    public ResponseEntity<UrlResponse> find(@RequestParam String url) {
        final var response = findByShortUrlUseCase.execute(url);
        final var responseUrl = new UrlResponse(response.shortUrl(), response.originalUrl());
        return ResponseEntity.ok(responseUrl);
    }
}
