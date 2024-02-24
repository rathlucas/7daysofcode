package dev.lucin.sevendaysofcode.integrations;

import dev.lucin.sevendaysofcode.http.HttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class OMDBMovieIntegration {

    @Value("${movies.integration.base.url}")
    private String baseUrl;

    @Value("${movies.integration.api.key}")
    private String apiKey;

    public Mono<String> getMovie(String id) {

        return HttpClient.webClient(baseUrl)
                .get()
                .uri("/?i=tt3896198&apikey={apiKey}", apiKey)
                .retrieve()
                .bodyToMono(String.class);
    }

}
