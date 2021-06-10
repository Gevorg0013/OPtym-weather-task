package com.weather.dto;

import java.util.List;
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
public class WeatherDTO {

    private CoordinatesDTO coord;

    private List<WeatherBaseDTO> weather;

    private String base;

    private MainDetailsDTO main;

    private long visibility;
}
