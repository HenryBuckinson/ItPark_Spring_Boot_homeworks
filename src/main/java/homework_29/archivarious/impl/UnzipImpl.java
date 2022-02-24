package homework_29.archivarious.impl;

import homework_29.properties.ZipUnzipProperties;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import net.lingala.zip4j.ZipFile;
import homework_29.archivarious.Unzip;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class UnzipImpl implements Unzip {

    private final ZipUnzipProperties properties;

    @Override
    @SneakyThrows
    public void unzip() {

        String password = "";
        final String from = "src\\main\\resources\\homework_29\\zip\\" + properties.getResultNameZipFile();
        final String where = "src\\main\\resources\\homework_29\\unzip\\";

        ZipFile zipFile = new ZipFile(from);
        if (zipFile.isEncrypted()) {
            zipFile.setPassword(password.toCharArray());
        }
        zipFile.extractAll(where);
    }
}
