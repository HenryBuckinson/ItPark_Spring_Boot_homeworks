package homework_33.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import homework_33.mapper.Response;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Класс служит для получения и обработки информации о валютах с ресурса: "https://www.cbr-xml-daily.ru/daily_json.js\".
 */
@Service
@NoArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private Map<String, Response.Valute> currencyCache = new LinkedHashMap<>();

    /**
     * @param valute - сокращённое название интересующей валюты.
     *               Метод отображает в консоль информацию о валюте RUB, по отношению к аргументу метода - valute.
     */
    @Override
    public void getRubInfoRelateTo(String valute) {
        String currencyInfoFromUrl = "https://www.cbr-xml-daily.ru/daily_json.js";
        if (currencyCache.isEmpty()) {
            getCurrencyInfo(currencyInfoFromUrl);
        }
        getInfoFromCache(valute);
    }

    /**
     * @param valute - сокращённое название валюты.
     *               Метод служит для получения информации об интересующей валюте из кэша.
     */
    private void getInfoFromCache(String valute) {
        for (Map.Entry<String, Response.Valute> element : currencyCache.entrySet()) {
            if (element.getKey().equals(valute)) {
                Response.Valute value = element.getValue();
                System.out.println("Информация о валюте " + valute + " по отношению к RUB:");
                System.out.println("Уникальный идентификатор - " + value.getId() + "\n" +
                        "Наименование - " + value.getName() + "\n" +
                        "Значение - " + value.getValue());
                break;
            }
        }
    }

    @Override
    public String getId(String valute) {
        String result = "";
        for (Map.Entry<String, Response.Valute> element : currencyCache.entrySet()) {
            if (element.getKey().equals(valute)) {
                Response.Valute value = element.getValue();
                result = value.getId();
                break;
            }
        }
        return result;
    }

    @Override
    public String getName(String valute) {
        String result = "";
        for (Map.Entry<String, Response.Valute> element : currencyCache.entrySet()) {
            if (element.getKey().equals(valute)) {
                Response.Valute value = element.getValue();
                result = value.getName();
                break;
            }
        }
        return result;
    }

    @Override
    public Double getValue(String valute) {
        Double result = 0.0;
        for (Map.Entry<String, Response.Valute> element : currencyCache.entrySet()) {
            if (element.getKey().equals(valute)) {
                Response.Valute value = element.getValue();
                result = value.getValue();
                break;
            }
        }
        return result;
    }

    @Override
    public Integer getNominal(String valute) {
        Integer result = 0;
        for (Map.Entry<String, Response.Valute> element : currencyCache.entrySet()) {
            if (element.getKey().equals(valute)) {
                Response.Valute value = element.getValue();
                result = value.getNominalValue();
                break;
            }
        }
        return result;
    }

    /**
     * @param url - ссылка на ресурс "Курсы валют ЦБ РФ".
     *            Метод служит для получения информации о всех валютах с ресурса "Курсы валют ЦБ РФ", которая по итогу загружается
     *            в кэш для дальнейшего использования.
     */
    @SneakyThrows
    private void getCurrencyInfo(String url) {
        URL currencyUrl = new URL(url);
        try (InputStream is = currencyUrl.openStream()) {
            ObjectMapper mapper = new ObjectMapper();
            Response requestTest = mapper.readValue(is, Response.class);
            Map<String, Response.Valute> allCurrency = requestTest.getValute();
            if (allCurrency != null) {
                this.currencyCache = allCurrency;
                System.out.println("Информация по адресу: \"" + url + "\" получена успешно.");
            } else {
                System.out.println("No data");
            }
        }
    }
}
