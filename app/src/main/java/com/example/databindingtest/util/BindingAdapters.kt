package com.example.databindingtest.util

import android.content.Context
import android.content.res.ColorStateList
import android.os.Build
import android.view.View
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.databindingtest.R
import com.example.databindingtest.data.Popularity

//progress visibility 여부
@BindingAdapter("app:hideIfZero")
fun hideIfZero(view: View, number: Int) {
    view.visibility = if (number == 0) View.GONE else View.VISIBLE
}

//Progress 크기
@BindingAdapter(value = ["app:progressScaled", "android:max"], requireAll = true)
fun setProgress(progressBar: ProgressBar, likes: Int, max: Int) {
    progressBar.progress = (likes * max / 5).coerceAtMost(max)
}


//Tint 색 여부
@BindingAdapter("app:progressTint")
fun tintPopularity(view: ProgressBar, popularity: Popularity) {

    val color = getAssociatedColor(popularity, view.context)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        view.progressTintList = ColorStateList.valueOf(color)
    }
}

private fun getAssociatedColor(popularity: Popularity, context: Context): Int {
    return when (popularity) {
        Popularity.NORMAL -> context.theme.obtainStyledAttributes(
            intArrayOf(android.R.attr.colorForeground)
        ).getColor(0, 0x000000)
        Popularity.POPULAR -> ContextCompat.getColor(context, android.R.color.holo_green_light)
        Popularity.STAR -> ContextCompat.getColor(context, android.R.color.holo_red_dark)
    }
}