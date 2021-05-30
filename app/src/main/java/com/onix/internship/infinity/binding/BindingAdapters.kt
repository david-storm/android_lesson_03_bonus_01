package com.onix.internship.infinity.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.onix.internship.infinity.R


@BindingAdapter("name_btn")
fun TextView.setNameBtn(count: Int) {
    text = when(count){
        0 -> context.getString(R.string.exit)
        else -> context.getString(R.string.prev)
    }
}