package com.example.a30daysofmemories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a30daysofmemories.data.Memory
import com.example.a30daysofmemories.ui.theme.Shapes
import com.example.a30daysofmemories.ui.theme._30DaysOfMemoriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _30DaysOfMemoriesTheme {
                Scaffold( modifier = Modifier.fillMaxSize(),
                    topBar = {TopBar()}
                ) { innerPadding ->
                    MemoriesApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MemoriesApp(modifier: Modifier = Modifier) {
    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.small_padding)),
        modifier = modifier,
         content = {
        items(Memory.memories) {
            MemoryCard(it.imageRes, it.descriptionRes, it.day, Modifier.padding(dimensionResource(id = R.dimen.small_padding)))
        }

        }
    )
}

@Composable
fun MemoryCard(@DrawableRes imageRes: Int, @StringRes descriptionRes: Int, day: Int, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        onClick = { expanded = !expanded},
        modifier = modifier
            .animateContentSize()
            .clip(Shapes.medium)
            .width(if (expanded) 256.dp else 128.dp)

    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.CenterHorizontally)

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
                .animateContentSize()
                .size(if (expanded) 256.dp else 128.dp)
                .padding(dimensionResource(id = R.dimen.small_padding))
                .clip(Shapes.small)

            ) {
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = stringResource(id = descriptionRes),
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.displayLarge,
            fontSize = 28.sp,
            maxLines = 1
        )
       },
        modifier = modifier)
}

@Preview
@Composable
fun CardPreview() {
    MemoryCard(imageRes = R.drawable.image1, R.string.image1,1)
}

@Preview
@Composable
fun AppPreview() {
    MemoriesApp()
}

