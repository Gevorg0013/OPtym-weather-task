package com.weather.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author gevorga
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GeoResponseDTO {

    private List<GeoBaseDTO> data;
}
