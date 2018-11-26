package api.handlers;

import api.services.ConnectionManager;
import api.models.Movie;
import api.services.IResponseReader;
import api.services.ResponseReader;

import java.net.HttpURLConnection;
import java.net.URL;

public class OmdbRequestHandler {

    public boolean Savemovie(String movieTitle) {
        //Assemble URL for request.
        String baseUrl = "http://http://www.omdbapi.com";
        String parameters = String.format("?t=%s", movieTitle.toLowerCase());
        URL url = new URL(baseUrl + parameters);

        //Establish connection and validate response code.
        HttpURLConnection connection = ConnectionManager.SetConnection("GET", "omdb.properties", url);
        int responseCode = connection.getResponseCode();
        System.out.println("Requesting movie details from from : " + url);
        System.out.println("Service responded with code : " + responseCode);

        if (responseCode != 200) {
            String message = "The server responded with an unsuccessful code.";
            throw new Exception(message + responseCode);
        }

        //Send request and buffer response into model.
        IResponseReader responseReader = new ResponseReader();
        Movie movie = responseReader.SerializeResponseToMovieObject(connection);

        //Check serialization worked correctly.
        if (movie == null) {
            throw new Exception("An error has occurred while serializing the quote response JSON");
        }
        true
    }
}