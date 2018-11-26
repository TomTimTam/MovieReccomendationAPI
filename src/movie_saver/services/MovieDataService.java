package movie_saver.services;

import movie_saver.models.Movie;

import java.util.List;

public class MovieDataService {
    private List<Movie> MovieList;

    private static MovieDataService ourInstance = new MovieDataService();

    public static MovieDataService getInstance(){
        return ourInstance;
    }

    public MovieDataService(){
        MoveList =
    }


    public String addMovie(Movie movie) {
        String newId = Integer.toString(MovieList.size() + 1);
        movie.setId
    }

    private static void SerializeMovieFileTo
}
