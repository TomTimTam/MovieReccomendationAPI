package Client;

import api.handlers.AndruxnetRequestHandler;
import api.handlers.OmdbRequestHandler;
import api.models.Movie;
import api.models.Quote;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class Main {
    public static void main(String[] args) {
        //Welcome user through interface
        System.out.println("Welcome to the movie generator, press any key to start");

        WaitForUserInput();

        while(true) {
            System.out.println("Thank you, I'm now fetching");
            System.out.println("a quote from Andruxnet...");

            AndruxnetRequestHandler andruxnetRequestHandler = new AndruxnetRequestHandler();

            Quote quote;
            try{
                quote = andruxnetRequestHandler.GetQuote();
            } catch (Exception exception)
            {
                System.out.println(exception.getMessage());
                //TODO : Log the exception
                break;
            }

            OmdbRequestHandler omdbRequestHandler = new OmdbRequestHandler();

            Movie movie;
            try {
                movie = omdbRequestHandler.GetMovie("TODO: Figure out movie title from the andruxnet")
            } catch (Exception exception)
            {
                System.out.println(exception.getMessage());
                //TODO : Log the exception
                break;
            }

            System.out.println("Would you like to save this movie to your favourites?");
        }
    }

    private static void WaitForUserInput() {
        try {
            System.in.read();
        } catch (Exception ignored) { }
    }

    private static void PostMovieToServer(Movie movie)
    {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("TODO: THIS"); //TODO: THIS <-------------------------

        String response = target.request(MediaType.APPLICATION_JSON)
                .accept(MediaType.TEXT_PLAIN_TYPE)
                .post(Entity.json(movie), String.class);
    }
}
