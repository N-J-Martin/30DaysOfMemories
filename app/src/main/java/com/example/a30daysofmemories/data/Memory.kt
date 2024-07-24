package com.example.a30daysofmemories.data


import com.example.a30daysofmemories.R
import com.example.a30daysofmemories.model.MemoryInfo

object Memory {
    val images = listOf<Int>(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10,
        R.drawable.image11,
        R.drawable.image12,
        R.drawable.image13,
        R.drawable.image14,
        R.drawable.image15,
        R.drawable.image16,
        R.drawable.image17,
        R.drawable.image18,
        R.drawable.image19,
        R.drawable.image20,
        R.drawable.image21,
        R.drawable.image22,
        R.drawable.image23,
        R.drawable.image24,
        R.drawable.image25,
        R.drawable.image26,
        R.drawable.image27,
        R.drawable.image28,
        R.drawable.image29,
        R.drawable.image30
    )

    val descriptions = listOf<Int>(
        R.string.image1,
        R.string.image2,
        R.string.image3,
        R.string.image4,
        R.string.image5,
        R.string.image6,
        R.string.image7,
        R.string.image8,
        R.string.image9,
        R.string.image10,
        R.string.image11,
        R.string.image12,
        R.string.image13,
        R.string.image14,
        R.string.image15,
        R.string.image16,
        R.string.image17,
        R.string.image18,
        R.string.image19,
        R.string.image20,
        R.string.image21,
        R.string.image22,
        R.string.image23,
        R.string.image24,
        R.string.image25,
        R.string.image26,
        R.string.image27,
        R.string.image28,
        R.string.image29,
        R.string.image30
    )

    val memories = setUpMemoryList()
}

private fun setUpMemoryList() : MutableList<MemoryInfo> {
    val list = mutableListOf<MemoryInfo>()
    for (i in 1..Memory.images.size) {
        list.add(MemoryInfo(Memory.images[i-1], Memory.descriptions[i-1], i))
    }
    return list
}