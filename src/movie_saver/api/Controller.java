package movie_saver.api;

import movie_saver.models.Movie;
import movie_saver.services.MovieDataService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;

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

        return Response.status(201).entity(result).build();
    }

}
