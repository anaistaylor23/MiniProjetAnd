package com.example.mylinkedin.ui.theme

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TopBar(navController: NavController) {
    val keyboardController = LocalSoftwareKeyboardController.current

    var motcle by remember { mutableStateOf("") }
    val viewModel: MainViewModel = viewModel();
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    TopAppBar(
        title = { Text(text = "Recherche", color = MaterialTheme.colors.primary) },
        modifier = Modifier.height(70.dp),
        actions = {
            OutlinedTextField(
                value = motcle,
                onValueChange = {
                    motcle=motcle
                },
                placeholder = {
                    Text(
                        "Recherche",
                        color= Color.White
                    )
                },
                maxLines = 1,
                modifier = Modifier.padding(top = 2.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide();
                    when (currentRoute) {
                        "films" -> viewModel.searchMovies(motcle);
                        "series" -> viewModel.SearchSeries(motcle);
                        "acteurs" -> viewModel.SearchPersonne(motcle);

                    }
                }),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        backgroundColor = Color.Transparent,
                        textColor = Color.Black
                    ),
                    textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.End),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            tint = Color.White,
                            contentDescription = "Rechercher"
                        )
                    },
                        )
                    })

    }

