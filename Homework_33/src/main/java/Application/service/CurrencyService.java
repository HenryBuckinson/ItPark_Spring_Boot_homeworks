package Application.service;

import Application.dto.ResultCurrencyDto;

public interface CurrencyService {
    ResultCurrencyDto getCurrencyInfo(String valute);
}