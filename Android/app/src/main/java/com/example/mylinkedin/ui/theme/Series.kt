package com.example.mylinkedin.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter


@Composable
fun Serie(navController: NavController, viewModel: MainViewModel){
    val series by viewModel.series.collectAsState()


            if (series.isEmpty()) {
                viewModel.lastSerie();
            } else {
                LazyVerticalGrid(
                    GridCells.Adaptive(128.dp),
                    verticalArrangement = Arrangement.spacedBy(7.dp),
                    horizontalArrangement = Arrangement.spacedBy(7.dp),
                ){
                    items(series.size) { i->
                        serieCell(navController = navController, serie = series[i])
                    }
                }
            }
        }

    @Composable
    fun serieCell(navController: NavController, serie: Serie){
        Card(modifier = Modifier.clickable {
            navController.navigate("seried" + "/" + serie.id)
        }){
            Text(text = serie.title)
            Image(
                painter = rememberAsyncImagePainter(imageURL + serie.poster_path),
                contentDescription = null,
                modifier = Modifier.size(height = 128.dp, width = 70.dp)
            )
        }
    }




