package movie_saver.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import movie_saver.models.Movie;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MovieDataService {

    //Add a movie to the list and save the file
    public boolean AddMovie(Movie movie) {
        String newId = Integer.toString(MovieList.size() + 1);
        movie.SetId(newId);

        List<Movie> savedMovieList = InitialiseSavedMoviesList();

        savedMovieList.add(movie);


    }

    public boolean ThisThing(String id) {
        List<Movie> savedMovieList = InitialiseSavedMoviesList();

        savedMovieList = RemoveMovie(savedMovieList, id);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonContents = objectMapper.writeValueAsString(savedMovieList);

            PrintWriter writer = new PrintWriter("savedmovies.json");

            writer.write(jsonContents);
            writer.close();

            return true;
        } catch (JsonProcessingException |FileNotFoundException exception)
        {
            System.out.println("Error occurred while rewriting savedmovies.json : " + exception.getMessage());
        }
        return false;
    }

    private List<Movie> RemoveMovie(List<Movie> movieList, String id) {
        for(Movie movie : movieList){
            if(movie.GetId().equals(id)){
                movieList.remove(movie);
            }
        }

        return movieList;
    }


    //Read list from saved json file with UTC-8 encoding.
    private List<Movie> InitialiseSavedMoviesList() {
        try{
            String json = ReadSavedMoviesFile(Charset.defaultCharset());

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(json, new TypeReference<List<Movie>>(){});
        }
        catch(IOException exception) {
            System.out.println("There is a problem reading the saved movie list file : " + exception.getMessage());
        }
        return null;
    }

    private static String ReadSavedMoviesFile(Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get("SavedMovies.json"));
        return new String(encoded, encoding);
    }
}
