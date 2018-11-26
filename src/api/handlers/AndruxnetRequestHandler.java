package api.handlers;

import api.services.ConnectionManager;
import api.models.Quote;
import api.services.ResponseReader;

import java.net.HttpURLConnection;
import java.net.URL;

public class AndruxnetRequestHandler {

    public Quote GetQuote() throws Exception {
        //Assemble URL for request.
        String baseUrl = "https://andruxnet-random-famous-quotes.p.mashape.com/";
        String parameters = "?cat=movies&count=1";
        URL url = new URL(baseUrl + parameters);

        //Establish connection and validate response code.
        HttpURLConnection connection = ConnectionManager.SetConnection("GET", "andruxnet.properties", url);
        int responseCode = connection.getResponseCode();
        System.out.println("Requesting quote from : " + url);
        System.out.println("Service responded with code : " + responseCode);

        if (responseCode != 200) {
            String message = "The server responded with an unsuccessful code. ";
            throw new Exception(message + responseCode);
        }

        //Send request and buffer response into model.
        ResponseReader responseReader = new ResponseReader();
        Quote quote = responseReader.SerializeResponseToQuoteObject(connection);

        //Check serialization worked correctly.
        if(quote.Author == null || quote.Quote == null || quote.Category == null){
            throw new Exception("An error has occurred while serializing the quote response JSON");
        }
        return quote;
    }
}
