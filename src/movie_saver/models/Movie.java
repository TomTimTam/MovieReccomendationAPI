package movie_saver.models;

import java.util.List;

public class Movie {
    private String Id;
    public String  Title;
    public String  Year;
    public String  Rated;
    public String  Released;
    public String  Runtime;
    public String  Genre;
    public String  Director;
    public String  Writer;
    public String  Actors;
    public String  Plot;
    public List<MovieRating> Ratings;
    public String  Poster;

    public void SetId(String id) {
        Id = id;
    }

    public String GetId() {
        return Id;
    }

}
