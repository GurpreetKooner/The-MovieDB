package com.example.themoviedb.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.themoviedb.data.repositories.MoviesRepository

class MoviesViewModelFactory(
    private val repository: MoviesRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MoviesViewModel(repository) as T
    }
}