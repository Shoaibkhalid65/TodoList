package com.example.todolist;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class BindingAdapters {
    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView imageView,int resId){
        imageView.setImageResource(resId);
    }
}
