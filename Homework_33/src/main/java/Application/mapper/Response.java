package Application.mapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

    @JsonProperty("Valute")
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Map<String, Valute> valute = new LinkedHashMap<>();

    @Data
    public static class Valute {

        @JsonProperty("ID")
        private String id;
        @JsonProperty("Name")
        private String name;
        @JsonProperty("Value")
        private Double value;
        @JsonProperty("Nominal")
        private Integer nominalValue;
    }
}
