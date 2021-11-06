package com.example.themoviedb.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themoviedb.R
import com.example.themoviedb.data.network.MoviesApi
import com.example.themoviedb.data.repositories.MoviesRepository
import kotlinx.android.synthetic.main.movies_fragment.*

class MoviesFragment : Fragment() {

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
        viewModel.getPopular()
        viewModel.getTopRated()
        viewModel.nowPlayingMoviesLiveData.observe(viewLifecycleOwner, { nowPlaying ->
            now_playing_rv.also {
                it.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                it.setHasFixedSize(true)
                it.adapter = MoviesAdapter(nowPlaying.results)
            }
        })
        viewModel.popularMoviesLiveData.observe(viewLifecycleOwner, { popular ->
            popular_rv.also {
                it.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                it.setHasFixedSize(true)
                it.adapter = MoviesAdapter(popular.results)
            }
        })
        viewModel.topRatedMoviesLiveData.observe(viewLifecycleOwner, { topRated ->
            top_rated_rv.also {
                it.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                it.setHasFixedSize(true)
                it.adapter = MoviesAdapter(topRated.results)
            }
        })

    }

}