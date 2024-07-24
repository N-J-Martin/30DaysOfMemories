package com.example.a30daysofmemories.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MemoryInfo(
    @DrawableRes val imageRes: Int,
    @StringRes val descriptionRes: Int,
    val day: Int
)
