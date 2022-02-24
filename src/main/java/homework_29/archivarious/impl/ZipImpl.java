package homework_29.archivarious.impl;


import homework_29.properties.ZipUnzipProperties;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionMethod;
import homework_29.archivarious.Zip;
import org.springframework.stereotype.Service;

import java.io.File;


@AllArgsConstructor
@Service
public class ZipImpl implements Zip {

    private final ZipUnzipProperties properties;

    @Override
    @SneakyThrows
    public void zip() {

        final String from = "src\\main\\resources\\homework_29\\source\\";
        final String where = "src\\main\\resources\\homework_29\\zip\\" + properties.getResultNameZipFile();

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
