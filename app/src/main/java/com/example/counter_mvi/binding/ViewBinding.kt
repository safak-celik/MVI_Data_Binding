package com.example.counter_mvi.binding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("is_visible")
fun setVisibility(view: View, isVisible: Boolean) {
    view.visibility = if (isVisible) View.VISIBLE else View.GONE
}