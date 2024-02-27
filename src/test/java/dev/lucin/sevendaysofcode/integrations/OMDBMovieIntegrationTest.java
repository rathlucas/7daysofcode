package dev.lucin.sevendaysofcode.integrations;

import dev.lucin.sevendaysofcode.exceptions.MovieIntegrationException;
import java.io.IOException;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.test.StepVerifier;

@SpringBootTest
class OMDBMovieIntegrationTest {

    @Value("${movies.integration.api.key}")
    private String apiKey;

    private OMDBMovieIntegration omdbMovieIntegration;

    private static MockWebServer mockWebServer;

    @Autowired
    private WebClient webClient;

    @BeforeAll
    static void setup() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @BeforeEach
    void initialize() {
        omdbMovieIntegration = new OMDBMovieIntegration(webClient);
        omdbMovieIntegration.setApiKey(apiKey);
    }

    @Test
    void givenAMovieId_whenGettingAMovie_thenShouldSuccessfullyReturn() {
        webClient = WebClient.builder()
                .baseUrl(mockWebServer.url("/?i=tt3896198&apikey={apiKey}").toString())
                .build();

        mockWebServer.enqueue(new MockResponse()
                .setStatus("200"));

        StepVerifier.create(omdbMovieIntegration.getMovie(""))
                .assertNext(Assertions::assertNotNull)
                .verifyComplete();
    }

    @Test
    void givenAMovieId_whenGettingAMovie_thenShouldThrowOnFailure() {
        webClient = WebClient.builder()
                .baseUrl(mockWebServer.url("/?i=tt3896198&apikey={apiKey}").toString())
                .build();

        omdbMovieIntegration.setApiKey("");

        mockWebServer.enqueue(new MockResponse()
                .setStatus("400"));

        StepVerifier.create(omdbMovieIntegration.getMovie(""))
                .expectError(MovieIntegrationException.class)
                .verify();
    }

}
