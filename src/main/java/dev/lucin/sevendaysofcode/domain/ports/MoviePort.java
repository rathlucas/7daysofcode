package dev.lucin.sevendaysofcode.domain.ports;

import reactor.core.publisher.Mono;

public interface MoviePort {

    Mono<String> getMovie(String id);
}
