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
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter

@Composable
fun Personnes(navController: NavHostController, viewModel: MainViewModel) {

    val personnes by viewModel.personnes.collectAsState()
    Text(text = "Les différents acteurs sont")
    if (personnes.isEmpty()) {
        viewModel.lastPersonne();
    } else {

        LazyVerticalGrid(
            GridCells.Adaptive(128.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp),
            horizontalArrangement = Arrangement.spacedBy(7.dp),
        ){
            items(personnes.size) { i->
                personnesCell(navController = navController, personnes= personnes[i])
            }
        }
    }
}

@Composable
fun personnesCell(navController: NavController, personnes: Personnes){
    Card(modifier = Modifier.clickable {
        navController.navigate("seried" + "/" + personnes.id)
    }){
        Text(text = personnes.name)
        Image(
            painter = rememberAsyncImagePainter(imageURL + personnes.profile_path),
            contentDescription = null,
            modifier = Modifier.size(height = 128.dp, width = 70.dp)
        )
    }
}

