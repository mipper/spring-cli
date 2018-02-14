package com.anaplan.modelsanitization.engine;

public class DefaultSanitisationEngine implements SanitizationEngine {

    @Override
    public String sanitize (final String value) {
        return reverse (value);
    }

    @Override
    public String unsanitize (final String ciphertext) {
        return reverse (ciphertext);
    }

    private String reverse (final String value) {
        return new StringBuilder(value).reverse ().toString ();
    }

}
