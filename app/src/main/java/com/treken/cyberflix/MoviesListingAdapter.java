package com.treken.cyberflix;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MoviesListingAdapter extends android.support.v7.widget.RecyclerView.Adapter {
    private static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mMovieName;
        private ImageView mMoviePoster;

        public ViewHolder(View root) {
            super( root );
            mMovieName = (TextView) root.findViewById( R.id.movie_name );
            mMoviePoster = (ImageView) root.findViewById( R.id.movie_poster );
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from( parent.getContext() ).inflate( R.layout.movie_grid_item, parent, false );
        return new ViewHolder( rootView );
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
