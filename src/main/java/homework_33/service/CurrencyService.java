package homework_33.service;

import homework_33.dto.ResultCurrencyDto;

public interface CurrencyService {
    ResultCurrencyDto getCurrencyInfo(String valute);
}