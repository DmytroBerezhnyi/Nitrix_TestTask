package com.example.dmytroberezhnyi_nitrix_testtask.presentation.base.architecture

import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImageFromDrawableResourcesId")
fun ImageView.setImageFromDrawableResourcesId(id: Drawable) {
    Glide.with(context)
        .load(id)
        .into(this)
}

@BindingAdapter("setImageFromUrl")
fun ImageView.setImageFromUrl(imageUrl: String) {
    Glide.with(context)
        .load(imageUrl)
        .into(this)
}