package homework_30.service.impl;

import homework_30.model.Country;
import homework_30.repository.CountryRepository;
import homework_30.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    /**
     * @param country - добавление атрибутов в таблицу Country.
     */
    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void find(String str) {
        countryRepository.findById(str);
    }
}
