package vn.techmaster.movie.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.movie.model.Movie;

@RestController
@CrossOrigin
@RequestMapping("")
public class RESTController {

  @GetMapping("/movies")
  public ResponseEntity<List<Movie>> listBooks() {
    List<Movie> movies = List.of(
      new Movie("Gone with the Wind", "Victor Fleming, David O. Selznick", 1939),
      new Movie("Bố Già", "Trấn Thành", 2020),
      new Movie("Parasite", "Bong Joon-ho", 2019),
      new Movie("Money Heist", "Álex Pina", 2018)
    );
    return ResponseEntity.ok().body(movies);
  }
}
