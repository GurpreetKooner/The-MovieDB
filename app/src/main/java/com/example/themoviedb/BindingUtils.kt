package com.example.themoviedb

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view)
        .load("https://image.tmdb.org/t/p/w500$url")
        .into(view)
}

@BindingAdapter("language")
fun language(textView:TextView, text: String) {
    if(text == "en"){
        textView.text = "English"
    }else if (text=="ta"){
        textView.text = "Tamil"
    }else if (text=="hi"){
        textView.text = "Hindi"
    }else if (text=="pa"){
        textView.text = "Punjabi"
    }else if (text=="ml"){
        textView.text = "Malayalam"
    }else if (text=="te"){
        textView.text = "Telugu"
    }else if (text=="kn"){
        textView.text = "Kannada"
    }else{
        textView.text = text
    }
}