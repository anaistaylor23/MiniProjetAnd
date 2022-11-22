package com.example.mylinkedin.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter


@Composable

fun DetailSerie(navController: NavController, id: String, viewModel: MainViewModel) {

    val viewModel: MainViewModel = viewModel;
    val serie by viewModel.serie.collectAsState()

    val url = "https://image.tmdb.org/t/p/w400/" + serie?.poster_path;

    if (id != null) {
        viewModel.getSerieDetail(id);
        if (serie == null) {
            Text("Aucun serie n'est sélectionner");
        } else {
            Column() {

                Text(id)
                TopAppBar(
                    title =
                    {
                        Text(
                            text = serie!!.original_name,
                            style = MaterialTheme.typography.h6,
                            textAlign = TextAlign.Center
                        )
                    }
                )

                Column() {


                    Spacer(modifier = Modifier.size(20.dp))
                    Image(
                        painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500" + serie!!.poster_path),
                        contentDescription = null,
                        modifier = Modifier.size(height = 190.dp, width = 110.dp)
                    )
                    Text(
                        text = serie!!.overview,
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = serie!!.first_air_date,
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}


