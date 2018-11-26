package api.services;

import api.models.Movie;
import api.models.Quote;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class ResponseReader implements IResponseReader {
    private ObjectMapper objectMapper;

    public ResponseReader() {
        objectMapper = new ObjectMapper();
    }

    public Quote SerializeResponseToQuoteObject(HttpURLConnection connection) throws Exception {

        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = inputBuffer.readLine()) != null) {
            response.append(inputLine);
        }

        inputBuffer.close();

        //Convert JSON string to object and return.
        return objectMapper.readValue(response.toString(), Quote.class);
    }

    public Movie SerializeResponseToMovieObject(HttpURLConnection connection) throws Exception{

        BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = inputBuffer.readLine()) != null){
            response.append(inputLine);
        }

        inputBuffer.close();

        //Convert JSON string to object and return.
        return objectMapper.readValue(response.toString(), Movie.class);
    }
}
