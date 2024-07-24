package com.example.a30daysofmemories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30daysofmemories.data.Memory
import com.example.a30daysofmemories.ui.theme.Shapes
import com.example.a30daysofmemories.ui.theme._30DaysOfMemoriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysOfMemoriesTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    MemoriesApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MemoriesApp(modifier: Modifier = Modifier) {
    var day = 1
    LazyVerticalGrid(columns = GridCells.Fixed(5), modifier = modifier) {
        items(Memory.memories) {
            MemoryCard(it, day)
            day++
        }
    }

}

@Composable
fun MemoryCard(@DrawableRes imageRes: Int, day: Int,  modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.clip(Shapes.medium)
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Text(
                text = stringResource(id = R.string.day, day),
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.small_padding))
            )
            /*
            Spacer(
                modifier = Modifier.padding(dimensionResource(id = R.dimen.medium_padding))
            )*/
            Box (modifier = Modifier
                .size(128.dp)
                .padding(dimensionResource(id = R.dimen.small_padding))
                .clip(Shapes.small)
            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    // add content description,and/or text after
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
            }

        }
    }
}

@Preview
@Composable
fun CardPreview() {
    MemoryCard(imageRes = R.drawable.image1, 1)
}

@Preview
@Composable
fun AppPreview() {
    MemoriesApp()
}

