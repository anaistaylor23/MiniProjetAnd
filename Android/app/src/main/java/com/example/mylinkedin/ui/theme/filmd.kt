package com.example.mylinkedin.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter



//détail quand on clique sur un film
@Composable
fun DetailFilm ( navController: NavController,id: String, viewModel: MainViewModel) {

    val viewModel: MainViewModel = viewModel();
    val movie by viewModel.movie.collectAsState()

    val url = "https://image.tmdb.org/t/p/w400/" + movie?.poster_path;

    if (id != null) {
        viewModel.getMovieDetail(id);
        if (movie == null) {
            "Aucun film n'est sélectionner";
        } else {

            TopAppBar(
                title =
                {
                    Text(
                        text = movie!!.title,
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )
                })
        }
        Image(
            painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500" + movie!!.poster_path),
            contentDescription = null,
            modifier = Modifier.size(height = 128.dp, width = 70.dp)
        )
    }
}
