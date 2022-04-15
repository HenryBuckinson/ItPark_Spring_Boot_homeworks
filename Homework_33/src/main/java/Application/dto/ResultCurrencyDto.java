package Application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultCurrencyDto {
    private String id;
    private String name;
    private Double value;
    private Integer nominalValue;
}