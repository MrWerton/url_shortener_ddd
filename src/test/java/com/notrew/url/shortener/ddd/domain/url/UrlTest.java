package com.notrew.url.shortener.ddd.domain.url;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UrlTest {
    @Test
    public void shouldCallCreateMethodAndReturnInstanceOfClassCorrectly(){
        final var ORIGINAL_URL = "http://example.com";

        final var SHORT_URL = "short.com";
        final var sut = Url.create(ORIGINAL_URL, SHORT_URL);

        Assertions.assertNotNull(sut);
        Assertions.assertEquals(sut.getShortUrl(), SHORT_URL);
        Assertions.assertEquals(sut.getOriginalUrl(), ORIGINAL_URL);
        Assertions.assertNotNull(sut.getCreatedAt());
        Assertions.assertNotNull(sut.getUpdatedAt());
        Assertions.assertNotNull(sut.getExpireAt());

    }
    @Test
    public void shouldReturnErrorWhenRequiredParametersAreNull(){

        Assertions.assertThrows(NullPointerException.class, ()->Url.create(null, null));

    }
}
