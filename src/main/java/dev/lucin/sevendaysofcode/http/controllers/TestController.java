package dev.lucin.sevendaysofcode.http.controllers;

import dev.lucin.sevendaysofcode.domain.ports.MoviePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@Tag(name = "Test Controller")
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {

    private final MoviePort moviePort;

    @GetMapping
    @Operation(description = "Get Movie by ID", responses = {
            @ApiResponse(responseCode = "200", description = "Successfully got a movie", content =
            @Content(mediaType = "application/json", schema = @Schema(contentSchema = String.class)))
    })
    public Mono<String> getMovieById() {
        return moviePort.getMovie("");
    }
}
