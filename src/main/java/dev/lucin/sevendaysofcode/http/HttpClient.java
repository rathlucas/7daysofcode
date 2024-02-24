package dev.lucin.sevendaysofcode.http;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.reactive.function.client.WebClient;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpClient {

    public static WebClient webClient(String baseUrl) {
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("Content-Type", "application/json")
                .build();
    }
}
