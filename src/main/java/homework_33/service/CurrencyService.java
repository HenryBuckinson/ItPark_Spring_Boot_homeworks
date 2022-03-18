package homework_33.service;

public interface CurrencyService {
    void getRubInfoRelateTo(String valute);

    String getId(String valute);

    String getName(String valute);

    Double getValue(String valute);

    Integer getNominal(String valute);
}