package com.example.themoviedb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class MoviesViewModel(
    private val repository: MoviesRepository
) : ViewModel() {
    private lateinit var job: Job
    private val _movies = MutableLiveData<NowPlaying>()
    val movies: LiveData<NowPlaying>
        get() = _movies

    fun getNowPlaying() {
        job = Coroutines.ioThenMain(
            { repository.getNowPlayingMovies() },
            { _movies.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}