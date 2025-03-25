package prince.coder.movies;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

//    This is First return Statement
//    @GetMapping
//    public String allMovies()
//    {
//        return "All Movies";
//    }

//    This is Second type of return Statement
//    @GetMapping
//    public ResponseEntity<String> getAllMovies()
//    {
//        return new ResponseEntity<>("All Movies are here!", HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<?> getAllMovies() {
        try {
            List<Movie> movies = movieService.allMovies();
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching movies: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    public ResponseEntity<List<Movie>> getAllMovies()
//    {
//        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
//    }

//    @GetMapping("/{id}")
//      public  ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id)
//      {
//          return new ResponseEntity<Optional<Movie>>(movieService.singleMovie((id)), HttpStatus.OK);
//      }
    @GetMapping("/{imdbId}")
        public  ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId)
        {
            return new ResponseEntity<Optional<Movie>>(movieService.singleMovie((imdbId)), HttpStatus.OK);
        }


}
