package com.example.themoviedb.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.themoviedb.R
import com.example.themoviedb.data.model.Result
import com.example.themoviedb.databinding.ItemMovieBinding

class MoviesAdapter(
    private val movies: List<Result>,
    private val listener: MovieClickListener
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
        holder.itemMovieBinding.root.setOnClickListener { listener.onMovieClickListener(holder.itemMovieBinding.root, movies[position]) }
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}