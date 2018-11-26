package api.services;

import api.models.Movie;
import api.models.Quote;

import java.net.HttpURLConnection;

public interface IResponseReader {
    Quote SerializeResponseToQuoteObject(HttpURLConnection connection) throws Exception;

    Movie SerializeResponseToMovieObject(HttpURLConnection connection) throws Exception;
}
