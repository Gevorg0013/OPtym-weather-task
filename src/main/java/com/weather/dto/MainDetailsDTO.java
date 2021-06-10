package com.weather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author gevorga
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MainDetailsDTO {

    @JsonProperty("temp")
    private double temp;

    @JsonProperty("feels_like")
    private double feelsLike;

    @JsonProperty("temp_min")
    private double tempMin;

    @JsonProperty("temp_max")
    private double tempMax;

    @JsonProperty("pressure")
    private long pressure;

    @JsonProperty("humidity")
    private long humidity;
}
