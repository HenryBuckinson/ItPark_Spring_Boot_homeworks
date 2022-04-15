package Application.archivarious.impl;

import Application.archivarious.Unzip;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import net.lingala.zip4j.ZipFile;
import org.springframework.stereotype.Service;
import Application.properties.ZipUnzipProperties;


@AllArgsConstructor
@Service
public class UnzipImpl implements Unzip {

    private final ZipUnzipProperties properties;

    @Override
    @SneakyThrows
    public void unzip() {

        String password = "";
        final String from = "Homework_29\\src\\main\\resources\\homework_29\\zip\\" + properties.getResultNameZipFile();
        final String where = "Homework_29\\src\\main\\resources\\homework_29\\unzip\\";

        ZipFile zipFile = new ZipFile(from);
        if (zipFile.isEncrypted()) {
            zipFile.setPassword(password.toCharArray());
        }
        zipFile.extractAll(where);
    }
}
