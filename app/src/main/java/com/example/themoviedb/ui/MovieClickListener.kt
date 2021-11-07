package com.example.themoviedb.ui

import android.view.View
import com.example.themoviedb.data.model.Result

interface MovieClickListener {
    fun onMovieClickListener(view: View, result: Result)
}