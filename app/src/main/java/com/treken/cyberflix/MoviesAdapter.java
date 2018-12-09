package com.treken.cyberflix;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    private String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";

    private List<Movie> movies;

    public MoviesAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( com.treken.navbar.R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView releaseDate;
        TextView title;
        TextView rating;
        TextView genres; // TODO: Add genres
        ImageView poster;

        public MovieViewHolder(View itemView) {
            super(itemView);
            releaseDate = itemView.findViewById( com.treken.navbar.R.id.item_movie_release_date);
            title = itemView.findViewById( com.treken.navbar.R.id.item_movie_title);
            rating = itemView.findViewById( com.treken.navbar.R.id.item_movie_rating);
            genres = itemView.findViewById( com.treken.navbar.R.id.item_movie_genre); // Add genres later
            poster = itemView.findViewById( com.treken.navbar.R.id.item_movie_poster );
        }

        public void bind(Movie movie) {
            releaseDate.setText(movie.getReleaseDate().split("-")[0]);
            title.setText(movie.getTitle());
            rating.setText(String.valueOf(movie.getRating()));
            genres.setText(""); // Add genres later
            Glide.with(itemView)
                    .load( IMAGE_BASE_URL + movie.getPosterPath() )
                    .apply( RequestOptions.placeholderOf( com.treken.navbar.R.color.colorPrimary ) )
                    .into( poster );
        }
    }
}