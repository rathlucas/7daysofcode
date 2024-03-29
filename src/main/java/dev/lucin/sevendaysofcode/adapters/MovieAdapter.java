package dev.lucin.sevendaysofcode.adapters;

import dev.lucin.sevendaysofcode.domain.models.Movie;
import dev.lucin.sevendaysofcode.domain.ports.MoviePort;
import dev.lucin.sevendaysofcode.integrations.OMDBMovieIntegration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieAdapter implements MoviePort {

    private final OMDBMovieIntegration omdbMovieIntegration;

    @Override
    public Mono<Movie> getMovie(String id) {
        log.info("Getting movie...");
        return omdbMovieIntegration.getMovie("");
    }
}
