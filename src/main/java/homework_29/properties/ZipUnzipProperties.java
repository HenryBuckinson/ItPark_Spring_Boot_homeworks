package homework_29.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Data
@ConfigurationProperties("spring.zipunzip")
@Configuration
public class ZipUnzipProperties {

    private String resultNameZipFile;
    private Locale locale;

}
