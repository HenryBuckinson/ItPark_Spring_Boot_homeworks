package Application.controller;

import Application.dto.ResultCurrencyDto;
import Application.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/valutes/rub")
public class InputController {

    private final CurrencyService currencyService;

    @GetMapping("/info")
    public ResultCurrencyDto getInfo(@RequestParam("valute") String str) {
        return currencyService.getCurrencyInfo(str);
    }

    @PostMapping("/convert")
    public ResultCurrencyDto getSpecInfo(@RequestParam("specify-valute") String str) {
        return currencyService.getCurrencyInfo(str);
    }
}
