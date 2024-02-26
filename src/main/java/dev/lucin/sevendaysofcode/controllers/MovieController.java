package dev.lucin.sevendaysofcode.controllers;

import dev.lucin.sevendaysofcode.domain.ports.MoviePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
@Tag(name = "Test Controller")
@RequestMapping("/movie")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieController {

    private final MoviePort moviePort;

    @GetMapping
    @Operation(description = "Get Movie by ID", responses = {
            @ApiResponse(responseCode = "200", description = "Successfully got a movie JSON data", content =
            @Content(mediaType = "application/json", schema = @Schema(contentSchema = String.class)))
    })
    public Mono<String> getMovieById(final Model model) {

        return moviePort.getMovie("").map(movie -> {
            model.addAttribute("movie", movie);
            return "index";
        });
    }
}
