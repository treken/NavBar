package com.treken.cyberflix;

/**
 * @author arun
 */
public class Api
{
    public static final String API_KEY = "d6983bfeba4fee6557be5d29b74cb06e"; // Dummy key. Enter your key here.
    public static final String GET_POPULAR_MOVIES = "http://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=" + API_KEY;
    public static final String POSTER_PATH = "http://image.tmdb.org/t/p/w185";
}