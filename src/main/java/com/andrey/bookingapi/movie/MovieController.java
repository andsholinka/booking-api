package com.andrey.bookingapi.movie;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.andrey.bookingapi.movie.models.Image;
import com.andrey.bookingapi.movie.models.Movie;
import com.andrey.bookingapi.movie.models.dto.MovieRequest;
import com.andrey.bookingapi.movie.models.dto.MovieResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/movies")
@Tag(name = "Movie", description = "Movie operations")
public class MovieController {

    private final MovieService movieService;
    private final ImageService imageService;

    @GetMapping("")
    public ResponseEntity<List<MovieResponse>> getAllMovies(@RequestParam("title") Optional<String> optionalTitle) {
        List<Movie> movies = this.movieService.getAllMovies(optionalTitle);
        List<MovieResponse> movieResponses = movies.stream().map(m -> m.convertMovieResponse()).toList();
        return ResponseEntity.status(HttpStatus.OK).body(movieResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getOne(@PathVariable("id") Long id) {
        Movie movie = this.movieService.findOneById(id);
        MovieResponse movieResponse = movie.convertMovieResponse();
        return ResponseEntity.status(HttpStatus.OK).body(movieResponse);
    }

    @GetMapping("/{id}/images")
    public ResponseEntity<byte[]> getOneImageByMovie(@PathVariable("id") Long id) throws IOException {
        Movie movie = this.movieService.findOneById(id);
        Image image = movie.getImage();
        Resource resource = this.imageService.load(image);

        return ResponseEntity.ok().contentType(MediaType.valueOf(image.getType()))
                .body(resource.getContentAsByteArray());
    }

    @PostMapping(value = "/image", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<MovieResponse> createOneWithImage(
            @Valid @RequestPart("movieRequest") MovieRequest movieRequest,
            @RequestPart("image") MultipartFile imageFile) {
        if (movieRequest.getTitle().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        String url = this.imageService.save(imageFile);
        Movie newMovie = movieRequest.convertToEntity();
        Image image = Image.builder().name(imageFile.getOriginalFilename()).type(imageFile.getContentType()).url(url)
                .build();
        newMovie.setImage(image);
        Movie saveMovie = this.movieService.createOne(newMovie);
        MovieResponse movieResponse = saveMovie.convertMovieResponse();

        return ResponseEntity.status(HttpStatus.CREATED).body(movieResponse);
    }

    @PostMapping("")
    public ResponseEntity<MovieResponse> createOne(@RequestBody MovieRequest movieRequest) {

        Movie newMovie = movieRequest.convertToEntity();
        Movie saveMovie = this.movieService.createOne(newMovie);
        MovieResponse movieResponse = saveMovie.convertMovieResponse();

        return ResponseEntity.status(HttpStatus.CREATED).body(movieResponse);
    }
}
