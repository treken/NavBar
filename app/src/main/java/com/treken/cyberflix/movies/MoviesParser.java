package com.treken.cyberflix.movies;

import android.support.annotation.NonNull;

import com.treken.cyberflix.Api;
import com.treken.cyberflix.movies.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
/**
 * @author arun
 */
public class MoviesParser
{
    public static final String RESULTS = "results";
    public static final String OVERVIEW = "overview";
    public static final String RELEASE_DATE = "release_date";
    public static final String POSTER_PATH = "poster_path";
    public static final String TITLE = "title";
    public static final String VOTE_AVERAGE = "vote_average";
    @NonNull
    public static List<Movie> parse(String json) throws JSONException
    {
        List<Movie> movies = new ArrayList<>(24);
        JSONObject response = new JSONObject(json);
        if(!response.isNull(RESULTS))
        {
            JSONArray results = response.getJSONArray(RESULTS);
            for (int i = 0; i < results.length(); i++)
            {
                movies.add(getMovie(results.getJSONObject(i)));
            }
        } else
        {
            // No results
        }
        return movies;
    }
    @NonNull
    private static Movie getMovie(JSONObject result) throws JSONException
    {
        Movie movie = new Movie();
        if(!result.isNull(OVERVIEW))
        {
            movie.setOverview(result.getString(OVERVIEW));
        }
        if(!result.isNull(RELEASE_DATE))
        {
            movie.setReleaseDate(String.valueOf(result.get(RELEASE_DATE)));
        }
        if(!result.isNull(POSTER_PATH))
        {
            movie.setPosterPath(Api.POSTER_PATH + result.getString(POSTER_PATH));
        }
        if(!result.isNull(TITLE))
        {
            movie.setTitle(result.getString(TITLE));
        }
        if(!result.isNull(VOTE_AVERAGE))
        {
            movie.setVoteAverage(result.getDouble(VOTE_AVERAGE));
        }
        return movie;
    }
}