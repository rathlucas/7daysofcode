package dev.lucin.sevendaysofcode.domain.ports;

import dev.lucin.sevendaysofcode.domain.models.Movie;
import reactor.core.publisher.Mono;

public interface MoviePort {

    Mono<Movie> getMovie(String id);
}
