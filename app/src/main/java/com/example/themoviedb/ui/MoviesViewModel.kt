package com.example.themoviedb.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.themoviedb.util.Coroutines
import com.example.themoviedb.data.repositories.MoviesRepository
import com.example.themoviedb.data.model.NowPlaying
import com.example.themoviedb.data.model.Popular
import kotlinx.coroutines.Job

class MoviesViewModel(
    private val repository: MoviesRepository
) : ViewModel() {
    private lateinit var job: Job
    private val nowPlaying = MutableLiveData<NowPlaying>()
    private val popular = MutableLiveData<Popular>()
    private val topRated = MutableLiveData<Popular>()
    val nowPlayingMoviesLiveData: LiveData<NowPlaying>
        get() = nowPlaying
    val popularMoviesLiveData: LiveData<Popular>
        get() = popular
    val topRatedMoviesLiveData: LiveData<Popular>
        get() = topRated

    fun getNowPlaying() {
        job = Coroutines.ioThenMain(
            { repository.getNowPlayingMovies() },
            { nowPlaying.value = it }
        )
    }
    fun getPopular() {
        job = Coroutines.ioThenMain(
            { repository.getPopular() },
            { popular.value = it }
        )
    }
    fun getTopRated() {
        job = Coroutines.ioThenMain(
            { repository.getTopRated() },
            { topRated.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}