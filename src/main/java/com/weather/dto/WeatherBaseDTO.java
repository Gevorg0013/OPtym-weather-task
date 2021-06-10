package com.weather.dto;

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
public class WeatherBaseDTO {

    private long id;

    private String main;

    private String description;
}
