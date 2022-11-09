package com.example.mylinkedin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mylinkedin.ui.theme.Film
import com.example.mylinkedin.ui.theme.MainViewModel
import com.example.mylinkedin.ui.theme.MyLinkedinTheme
import com.example.mylinkedin.ui.theme.Profile
import androidx.compose.foundation.layout.Column as Column1


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewmodel: MainViewModel by viewModels()
        setContent {
            MyLinkedinTheme() {
                // A surface container using the 'background' color from the theme
                Column1() {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        var color = MaterialTheme.colors.background
                        NavControl(viewModel = viewmodel)
                    }

                }
            }
        }
    }
}


@Composable
fun NavControl(viewModel: MainViewModel) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                BottomNavigationItem(
                    icon = { Icon(R.drawable.ic_baseline_movie_24, contentDescription = null) },
                    label = { Text("Film") },
                    selected = currentDestination?.hierarchy?.any { it.route == "Film" } == true,
                    onClick = {
                        navController.navigate("Film") {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                    label = { Text("Series") },
                    selected = currentDestination?.hierarchy?.any { it.route == "Series" } == true,
                    onClick = {
                        navController.navigate("Series") {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                    label = { Text("Personnes") },
                    selected = currentDestination?.hierarchy?.any { it.route == "Personnes" } == true,
                    onClick = {
                        navController.navigate("Personnes") {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) {
        NavHost(navController = navController, modifier = Modifier, startDestination = "Profil") {
            composable("Profil") {
                Profile(navController = navController)
            }
            composable("Film") {
                Film(navController = navController, viewModel = viewModel)
            }
        }
    }
}











