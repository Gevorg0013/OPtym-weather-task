package com.weather.controller;

import com.weather.dto.WeatherDTO;
import com.weather.service.WeatherService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gevorga
 */
@RestController
@RequestMapping("/api")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @PostMapping("/weather/get")
    public ResponseEntity getWeather(
            final @RequestParam String city,
            final @RequestParam String country
    ) {

        if (city.isEmpty() || country.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("City/country are invalid!");
        }

        final String locationName = String.format("%s %s", city, country);
        final Optional<WeatherDTO> weather = this.weatherService.getWeather(locationName);

        if (!weather.isPresent()) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Failed to get weather for the location!");
        }

        return ResponseEntity.ok(weather.get());
    }
}
