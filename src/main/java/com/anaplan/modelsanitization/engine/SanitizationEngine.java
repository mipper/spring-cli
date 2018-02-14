package com.anaplan.modelsanitization.engine;

public interface SanitizationEngine {

    String sanitize (final String value);

    String unsanitize (final String cipher);

}
