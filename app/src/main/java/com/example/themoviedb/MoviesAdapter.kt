package com.example.themoviedb

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.databinding.ItemMovieBinding

class MoviesAdapter(
    private val movies: List<Result>
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    inner class MoviesViewHolder(
        val itemMovieBinding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(itemMovieBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_movie,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.itemMovieBinding.movie = movies[position]
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}