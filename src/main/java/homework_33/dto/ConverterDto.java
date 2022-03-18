package homework_33.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConverterDto {
    private Double value;
    private Integer nominalValue;
}
