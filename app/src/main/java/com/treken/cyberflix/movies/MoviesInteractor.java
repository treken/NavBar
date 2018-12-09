package com.treken.cyberflix.movies;

import com.treken.cyberflix.Api;
import com.treken.cyberflix.network.RequestGenerator;
import com.treken.cyberflix.network.RequestHandler;
import com.squareup.okhttp.Request;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import rx.Observable;
import rx.functions.Func0;

/**
 * @author arun
 */
public class MoviesInteractor implements IMoviesInteractor
{
    @Override
    public Observable<List<Movie>> fetchPopularMovies()
    {
        return Observable.defer(new Func0<Observable<List<Movie>>>()
        {
            @Override
            public Observable<List<Movie>> call()
            {
                try
                {
                    return Observable.just(get());
                } catch (Exception e)
                {
                    return Observable.error(e);
                }
            }

            private List<Movie> get() throws IOException, JSONException
            {
                String url = Api.GET_POPULAR_MOVIES;
                Request request = RequestGenerator.get(url);
                String response = RequestHandler.request(request);
                return MoviesParser.parse(response);
            }
        });
    }
}