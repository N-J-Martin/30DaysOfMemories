package com.example.a30daysofmemories.model

import androidx.annotation.DrawableRes

data class MemoryInfo(
    @DrawableRes val imageRes: Int,
    val day: Int
)
