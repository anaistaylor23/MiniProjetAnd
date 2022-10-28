package com.example.mylinkedin.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
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
            style = MaterialTheme.typography.h4
        )
        Text(
            text = "Étudiante en alternance à ISIS",
            modifier = Modifier
                .padding(20.dp)
        )

        Button(onClick = { navController.navigate("Film")}) {
            Text("Démarrer")
        }

    }
    @Composable
    fun Greeting() {
        Profile()
    }


}