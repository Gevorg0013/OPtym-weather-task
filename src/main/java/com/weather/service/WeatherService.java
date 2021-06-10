package com.weather.service;

import com.weather.client.GeoClient;
import com.weather.client.WeatherClient;
import com.weather.dto.GeoBaseDTO;
import com.weather.dto.GeoResponseDTO;
import com.weather.dto.WeatherDTO;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gevorga
 */
@Service
public class WeatherService {

    @Autowired
    private GeoClient geoClient;

    @Autowired
    private WeatherClient weatherClient;

    public Optional<WeatherDTO> getWeather(final String locationName) {

        if (locationName == null || locationName.isEmpty()) {
            return Optional.empty();
        }

        final Optional<GeoResponseDTO> geoLocaiton = this.geoClient.getGeoLocations(locationName);
        if (!geoLocaiton.isPresent()) {
            return Optional.empty();
        } else if (geoLocaiton.get().getData().isEmpty()) {
            System.out.println("Failed to get geo for the locaiton: " + geoLocaiton);
            return Optional.empty();
        }

        final GeoBaseDTO geoDetails = geoLocaiton.get().getData().get(0);

        System.out.println(String.format("location details: lat - %s, long - %s", geoDetails.getLatitude(), geoDetails.getLongitude()));
        final Optional<WeatherDTO> weather = this.weatherClient.getWeather(geoDetails.getLatitude(), geoDetails.getLongitude());

        return weather;
    }
}
