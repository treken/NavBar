package com.treken.cyberflix.movies;

import rx.Subscription;
/**
 * @author arun
 */
public interface IMoviesPresenter
{
    Subscription displayPopularMovies();
}