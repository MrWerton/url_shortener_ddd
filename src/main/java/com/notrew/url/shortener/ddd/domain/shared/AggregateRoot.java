package com.notrew.url.shortener.ddd.domain.shared;

public abstract class AggregateRoot<ID extends Identifier> extends  Entity<ID>{
    protected AggregateRoot(ID id) {
        super(id);
    }

}
