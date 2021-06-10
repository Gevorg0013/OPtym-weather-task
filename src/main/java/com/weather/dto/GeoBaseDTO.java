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
public class GeoBaseDTO {

    private double latitude;

    private double longitude;

    private String name;
}
