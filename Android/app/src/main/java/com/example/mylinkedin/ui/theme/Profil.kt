package com.example.mylinkedin.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mylinkedin.R




@Composable
fun Profile(navController:NavController) {

    Column() {
        Image(
            painterResource(id = R.drawable.sheitan),
            contentDescription = "Cheval",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)

        )
        Text(
            text = "Anais TAYLOR",
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Étudiante en alternance à ISIS",
            style = MaterialTheme.typography.h6,

        )
        Text(
            text = "mail: anaisrose11@gmail.com",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center

        )
        Button(onClick = { navController.navigate("Film")}) {
            Text("Acces à TMDB ")
        }

    }
    @Composable
    fun Greeting() {
        Profile(navController)
    }


}