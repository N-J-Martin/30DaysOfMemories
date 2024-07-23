package com.example.a30daysofmemories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

}

