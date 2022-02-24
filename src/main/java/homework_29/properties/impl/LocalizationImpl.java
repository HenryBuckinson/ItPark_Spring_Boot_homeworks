package homework_29.properties.impl;

import homework_29.properties.Localization;
import homework_29.properties.ZipUnzipProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LocalizationImpl implements Localization {

    private final MessageSource messageSource;
    private final ZipUnzipProperties properties;

    @Override
    public String localize(String key, Object... var) {
        return messageSource.getMessage(key, var, properties.getLocale());
    }
}
