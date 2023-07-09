package com.notrew.url.shortener.ddd.domain.url.entities;

import com.notrew.url.shortener.ddd.domain.shared.Identifier;
import com.notrew.url.shortener.ddd.domain.shared.utils.IdUtils;

import java.util.Objects;

public class UrlID extends Identifier {

    private final String value;

    private UrlID(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static UrlID unique() {
        return UrlID.from(IdUtils.uuid());
    }

    public static UrlID from(final String anId) {
        return new UrlID(anId);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UrlID that = (UrlID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

}
