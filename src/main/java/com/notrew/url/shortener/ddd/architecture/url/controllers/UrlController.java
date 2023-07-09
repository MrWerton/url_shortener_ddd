package com.notrew.url.shortener.ddd.architecture.url.controllers;

import com.notrew.url.shortener.ddd.application.url.create.CreateUrlUseCase;
import com.notrew.url.shortener.ddd.application.url.create.dto.UrlDTO;
import com.notrew.url.shortener.ddd.application.url.findById.FindByIdUseCase;
import com.notrew.url.shortener.ddd.architecture.url.models.CreateUrlRequest;
import com.notrew.url.shortener.ddd.architecture.url.models.UrlResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlController {
    private final CreateUrlUseCase createUrlUseCase;
    private final FindByIdUseCase findByIdUseCase;


    public UrlController(CreateUrlUseCase createUrlUseCase, FindByIdUseCase findByIdUseCase) {
        this.createUrlUseCase = createUrlUseCase;
        this.findByIdUseCase = findByIdUseCase;
    }

    @PostMapping("/")
    public ResponseEntity<?> createUrl(@RequestBody CreateUrlRequest body) {
        final var url = UrlDTO.with(body.originalUrl(), body.shortUrl());
        this.createUrlUseCase.execute(url);
        return ResponseEntity.ok(url);

    }

    @GetMapping("/")
    public ResponseEntity<UrlResponse> get(@RequestParam String id) {
        System.out.println(id);
        final var response = findByIdUseCase.execute(id);
        final var url = new UrlResponse(response.shortUrl());
        return ResponseEntity.ok(url);
    }
}
