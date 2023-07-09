package com.notrew.url.shortener.ddd.domain.shared;

import java.util.Objects;

public abstract class Entity<ID extends Identifier> {

     protected final ID id;

    protected Entity(final ID id) {
        Objects.requireNonNull(id, "id should not be null");
        this.id = id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Entity<?> entity)) return false;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



    public  ID getID() {
       return this.id;
    }


}
