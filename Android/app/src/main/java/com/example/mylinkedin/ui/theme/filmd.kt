package com.example.mylinkedin.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
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
import coil.compose.AsyncImage
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
            Column() {


                Spacer(modifier = Modifier.size(50.dp))
                Image(
                    painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500" + movie!!.poster_path),
                    contentDescription = null,
                    modifier = Modifier.size(height = 190.dp, width = 110.dp)
                )
                Text(
                    text = "Résumé",
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = movie!!.overview,
                    textAlign = TextAlign.Center,
                )
                Text(
                    text = "Date de sortie : " +  movie!!.release_date,
                    textAlign = TextAlign.Center,
                )

                if (movie!!.credits.cast.isEmpty()) {
                    Text("pas d'acteurs")
                } else {
                    LazyVerticalGrid(GridCells.Adaptive(120.dp)) {
                        items(movie!!.credits.cast) { cast ->
                            Card() {
                                Column() {


                                    AsyncImage(
                                        model = url +cast.profile_path,
                                        contentDescription = "Cast",
                                    )
                                    Spacer(Modifier.height(20.dp))
                                    Text(cast.original_name)
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}