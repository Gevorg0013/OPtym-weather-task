package com.weather.client;

import com.weather.dto.GeoResponseDTO;
import io.vavr.control.Try;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author gevorga
 */
@Component
public class GeoClient {

    @Autowired
    private RestTemplate restTemplate;

    private final static String GEO_API = "http://api.positionstack.com/v1/forward";

    private final static String API_KEY = "185780d157089af442ad9977ce029824";

    public Optional<GeoResponseDTO> getGeoLocations(final String locationName) {

        final String url = UriComponentsBuilder.fromUriString(GEO_API)
                .queryParam("access_key", API_KEY)
                .queryParam("query", locationName)
                .toUriString();

        System.out.println("Generated URL for geo: " + url);

        final HttpHeaders headers = new HttpHeaders();
        headers.add("Host", "api.positionstack.com");

        final Try<ResponseEntity<GeoResponseDTO>> response = Try.of(()
                -> this.restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), GeoResponseDTO.class));

        if (!response.isSuccess()) {
            System.out.println("Failed to get geo locaiton: " + response.getCause().getLocalizedMessage());
            return Optional.empty();
        }

        return Optional.of(response.get().getBody());
    }
}
