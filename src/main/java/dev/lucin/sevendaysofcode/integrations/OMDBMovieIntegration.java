package dev.lucin.sevendaysofcode.integrations;

import dev.lucin.sevendaysofcode.domain.models.Movie;
import dev.lucin.sevendaysofcode.exceptions.MovieIntegrationException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OMDBMovieIntegration {

    @Value("${movies.integration.api.key}")
    @Setter(AccessLevel.PROTECTED)
    private String apiKey;

    private final WebClient webClient;

    public Mono<Movie> getMovie(String id) {

        return webClient
                .get()
                .uri("/?i=tt3896198&apikey={apiKey}", apiKey)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, res -> res.bodyToMono(String.class)
                        .flatMap(error -> {
                            log.info("Error while fetching: {}", error);
                            return Mono.error(new MovieIntegrationException(error, res.statusCode().value()));
                        }))
                .bodyToMono(Movie.class);
    }

}
