package com.example.mylinkedin.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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
fun DetailPersonne (navController: NavController, id: String, viewModel: MainViewModel) {

    val viewModel: MainViewModel = androidx.lifecycle.viewmodel.compose.viewModel();
    val personne by viewModel.personne.collectAsState()


    val url = "https://image.tmdb.org/t/p/w400/" + personne?.profile_path;

    if (id != null) {
        viewModel.getPersonneDetail(id);
        if (id == null) {
            "Aucun film n'est sélectionner";
        } else {
            Column() {


            TopAppBar(
                title =
                {
                    Text(
                        text = personne!!.original_name,
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )
                })

        Image(
            painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500" + personne!!.profile_path),
            contentDescription = null,
            modifier = Modifier.size(height = 128.dp, width = 70.dp)
        )
    }
}}}
