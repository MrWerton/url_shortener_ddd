package com.notrew.url.shortener.ddd.application.shared.usecases;

public abstract class UseCase<I, O> {
    public abstract O execute(I data);
}
