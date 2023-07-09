package com.notrew.url.shortener.ddd.application.shared.usecases;

public abstract class InputUseCase<I> {
        public abstract void execute(I data);
}
