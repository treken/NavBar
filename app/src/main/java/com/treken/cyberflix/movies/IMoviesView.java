package com.treken.cyberflix.movies;

import java.util.List;
/**
 * @author arun
 */
public interface IMoviesView
{
    void showMovies(List<Movie> movies);
    void loadingStarted();
    void loadingFailed(String errorMessage);
}