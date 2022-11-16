package com.example.mylinkedin.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter

val imageURL = "https://image.tmdb.org/t/p/w500"

//afficher film de la semaine
@Composable
fun Film(navController: NavController, viewModel: MainViewModel) {
    val movies by viewModel.movies.collectAsState()
    var title by rememberSaveable { mutableStateOf("") }
    if (movies.isEmpty()) {
        viewModel.lastMovie();
    } else {
        LazyVerticalGrid(
            GridCells.Adaptive(128.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp),
            horizontalArrangement = Arrangement.spacedBy(7.dp),
        ){
                items(movies.size) { i->
                    filmCell(navController = navController, movie = movies[i])
                }
            }
    }
}

@Composable
fun filmCell(navController: NavController, movie: Movie){
    Card(modifier = Modifier.clickable {
        navController.navigate("seried" + "/" + movie.id)
    }){
    Text(text = movie.title)
    Image(
        painter = rememberAsyncImagePainter(imageURL + movie.poster_path),
        contentDescription = null,
        modifier = Modifier.size(height = 128.dp, width = 70.dp)
    )}
}




