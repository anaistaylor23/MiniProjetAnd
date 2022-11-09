package com.example.mylinkedin.ui.theme

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController


@Composable
fun Film(navController: NavController,viewModel: MainViewModel){
    val movies by viewModel.movies.collectAsState()
    var namefilm by rememberSaveable { mutableStateOf("") }
}
