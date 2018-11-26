package movie_saver.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import movie_saver.models.Movie;
import movie_saver.services.MovieDataService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Path("movies")
public class Controller {

    private MovieDataService MovieDataService;

    public Controller(MovieDataService movieDataService) {
        MovieDataService = movieDataService;
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response CreateMovie(String data)
    {
        String result =  "Data post : " + data;

        ObjectMapper mapper = new ObjectMapper();

        try {
            Movie movie = mapper.readValue(data, Movie.class);
        } catch(Exception e)
        {
            System.out.println("There was an error during unmarshalling of a Movie. Data : " + data);
            return null;
        }



        return Response.status(201).entity(result).build();
    }
}
