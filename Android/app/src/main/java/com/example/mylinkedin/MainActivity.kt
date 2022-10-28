package com.example.mylinkedin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mylinkedin.ui.theme.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewmodel : MainViewModel by viewModels()
        setContent {
            MyLinkedinTheme {
                // A surface container using the 'background' color from the theme
                    Column() {
                        modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    navHost(navController= navController, startDestination= "Profil"){
                        composable("Profil"){ Profile() }
                        composable("Film"){ Film(navController)}
                    }
                }
            }
        }
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {

    }
}







