package com.example.themoviedb.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themoviedb.R
import com.example.themoviedb.data.model.Result
import com.example.themoviedb.data.network.MoviesApi
import com.example.themoviedb.data.repositories.MoviesRepository
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment : Fragment(), MovieClickListener {

    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movies_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = MoviesApi()
        val repository = MoviesRepository(api)
        factory = MoviesViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]
        viewModel.getNowPlaying()
        viewModel.nowPlayingMoviesLiveData.observe(viewLifecycleOwner, { nowPlaying ->
            now_playing_rv.also {
                it.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                it.setHasFixedSize(true)
                it.adapter = MoviesAdapter(nowPlaying.results, this)
            }
        })
        viewModel.getUpcoming()
        viewModel.upcomingMoviesLiveData.observe(viewLifecycleOwner, { upcoming ->
            upcoming_rv.also {
                it.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                it.setHasFixedSize(true)
                it.adapter = MoviesAdapter(upcoming.results, this)
            }
        })
        viewModel.getPopular()
        viewModel.popularMoviesLiveData.observe(viewLifecycleOwner, { popular ->
            popular_rv.also {
                it.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                it.setHasFixedSize(true)
                it.adapter = MoviesAdapter(popular.results,this)
            }
        })
        viewModel.getTopRated()
        viewModel.topRatedMoviesLiveData.observe(viewLifecycleOwner, { topRated ->
            top_rated_rv.also {
                it.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                it.setHasFixedSize(true)
                it.adapter = MoviesAdapter(topRated.results, this)
            }
        })
    }

    override fun onMovieClickListener(view: View, result: Result) {
        Toast.makeText(requireContext(),result.title,Toast.LENGTH_LONG).show()
    }
}