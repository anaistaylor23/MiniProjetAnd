package com.example.mylinkedin.ui.theme

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavController

@Composable

fun Series(navController: NavController, viewModel: MainViewModel){
    val series by viewModel.series.collectAsState()
    var nameseries by rememberSaveable {mutableStateOf("") }
    }
