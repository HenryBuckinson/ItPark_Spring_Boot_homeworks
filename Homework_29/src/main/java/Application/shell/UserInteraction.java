package Application.shell;


import Application.properties.impl.LocalizationImpl;
import Application.archivarious.impl.UnzipImpl;
import Application.archivarious.impl.ZipImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import Application.properties.ZipUnzipProperties;

@Slf4j
@ShellComponent
@RequiredArgsConstructor
public class UserInteraction {

    private final MessageSource messageSource;
    private final ZipUnzipProperties properties;
    private final ZipImpl zip;
    private final UnzipImpl unzip;
    private final LocalizationImpl localization;


    @ShellMethod(value = "Greetings", key = {"hi", "hey", "Hello"})
    public void show() {
        log.info("Welcome to program!");
    }

    @ShellMethod(value = "Zipping", key = {"zip", "makeZip", "Z", "Zip"})
    public void zip() {
        log.info(localization.localize("locale.zip", properties.getResultNameZipFile()));
        zip.zip();
    }

    @ShellMethod(value = "Unzipping", key = {"unzip", "makeUnzip", "UZ", "Unzip"})
    public void unzip() {
        log.info(localization.localize("locale.unzip", properties.getResultNameZipFile()));
        unzip.unzip();
    }

}
