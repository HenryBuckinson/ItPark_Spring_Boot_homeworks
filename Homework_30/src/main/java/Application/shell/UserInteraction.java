package Application.shell;

import Application.model.Country;
import Application.model.Subscriber;
import Application.service.CountryService;
import Application.service.SubscriberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@Slf4j
@ShellComponent
@RequiredArgsConstructor
public class UserInteraction {

    private final CountryService countryService;
    private final SubscriberService subscriberService;


    @ShellMethod(value = "Adding country", key = {"addCountry", "AC"})
    public void addCountry(@ShellOption("-ip") String ip,
                           @ShellOption("-country") String country,
                           @ShellOption("-cCode") String countryCode,
                           @ShellOption("-city") String city,
                           @ShellOption("-curr") String currency) {
        countryService.save(new Country(ip, country, countryCode, city, currency));
    }

    @ShellMethod(value = "Adding subscriber", key = {"addSub", "AS"})
    public void addSubscriber(@ShellOption("-ip") String ip,
                              @ShellOption("-fName") String fName,
                              @ShellOption("-sName") String sName,
                              @ShellOption("-Gender") String gender) {
        subscriberService.save(new Subscriber(ip, fName, sName, gender));
    }
}
