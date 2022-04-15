package Application.service;

import Application.model.Country;

public interface CountryService {
    void save(Country country);
    void find(String str);
}
