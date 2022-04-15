package Application.archivarious.impl;


import Application.archivarious.Zip;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionMethod;
import org.springframework.stereotype.Service;
import Application.properties.ZipUnzipProperties;

import java.io.File;


@AllArgsConstructor
@Service
public class ZipImpl implements Zip {

    private final ZipUnzipProperties properties;

    @Override
    @SneakyThrows
    public void zip() {

        final String from = "Homework_29\\src\\main\\resources\\homework_29\\source\\";
        final String where = "Homework_29\\src\\main\\resources\\homework_29\\zip\\" + properties.getResultNameZipFile();

        ZipParameters parameters = new ZipParameters();
        parameters.setCompressionMethod(CompressionMethod.DEFLATE);
        ZipFile zipFile = new ZipFile(where);

        File targetFile = new File(from);
        if (targetFile.isFile()) {
            zipFile.addFile(targetFile, parameters);
        } else if (targetFile.isDirectory()) {
            zipFile.addFolder(targetFile, parameters);
        }
    }

}
