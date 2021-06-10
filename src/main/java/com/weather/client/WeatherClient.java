package com.weather.client;

import com.weather.dto.WeatherDTO;
import io.vavr.control.Try;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author gevorga
 */
@Component
public class WeatherClient {

    @Autowired
    private RestTemplate restTemplate;

    private final static String WATHER_API = "api.openweathermap.org/data/2.5/weather";

    private final static String API_KEY = "cf1b854910b87295acfe48e14ec69b55";

    public Optional<WeatherDTO> getWeather(final double lat, final double lon) {

        final String url = UriComponentsBuilder.fromUriString(WATHER_API)
                .queryParam("appid", API_KEY)
                .queryParam("lat", lat)
                .queryParam("lon", lon)
                .toUriString();

        System.out.println("Generated url: " + url);

        Try<WeatherDTO> response = Try.of(()
                -> this.restTemplate.getForObject(url, WeatherDTO.class));

        if (!response.isSuccess()) {
            System.out.println("Failed to get weather: " + response.getCause().getLocalizedMessage());
            return Optional.empty();
        }

        System.out.println("Got weather details successfully!");
        return Optional.of(response.get());
    }
}
