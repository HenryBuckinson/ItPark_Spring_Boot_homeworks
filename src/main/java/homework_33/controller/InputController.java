package homework_33.controller;

import homework_33.dto.ConverterDto;
import homework_33.dto.ResultDto;
import homework_33.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/getRubInfo")
public class InputController {

    private final CurrencyService currencyService;

    @PostMapping("/valute")
    public ResultDto getInfo(@RequestParam("valute") String str) {
        currencyService.getRubInfoRelateTo(str);
        return new ResultDto(currencyService.getId(str),
                currencyService.getName(str),
                currencyService.getValue(str));
    }

    @PostMapping("/converter")
    public ConverterDto getSpecInfo(@RequestParam("specValute") String str) {
        currencyService.getRubInfoRelateTo(str);
        return new ConverterDto(currencyService.getValue(str), currencyService.getNominal(str));
    }
}
