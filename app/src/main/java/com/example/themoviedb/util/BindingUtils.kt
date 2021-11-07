package com.example.themoviedb.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun loadImage(view: ImageView, url: String?) {

    Glide.with(view)
        .load("https://image.tmdb.org/t/p/w500$url")
        .into(view)
}

@BindingAdapter("language")
fun language(textView: TextView, text: String) {
    when (text) {
        "en" -> {
            textView.text = "English"
        }
        "ta" -> {
            textView.text = "Tamil"
        }
        "hi" -> {
            textView.text = "Hindi"
        }
        "pa" -> {
            textView.text = "Punjabi"
        }
        "ml" -> {
            textView.text = "Malayalam"
        }
        "te" -> {
            textView.text = "Telugu"
        }
        "kn" -> {
            textView.text = "Kannada"
        }
        "no" -> {
            textView.text = "Norwegian"
        }
        "ko" -> {
            textView.text = "Korean"
        }
        "it" -> {
            textView.text = "Italian"
        }
        "ja" -> {
            textView.text = "Japanese"
        }
        else -> {
            textView.text = text
        }
    }
}