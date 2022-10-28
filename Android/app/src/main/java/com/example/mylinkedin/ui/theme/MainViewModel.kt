package com.example.mylinkedin.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainViewModel : ViewModel() {
    val movies = MutableStateFlow<List<Movie>>(listOf())


    val apikey ="fb07b2b57a58124103dc89332ac95ee7"

    val service = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(TmdbAPI::class.java )

    fun searchMovies(motcle : String) {
        viewModelScope.launch {
            movies.value= service.getFilmParMotCle(apikey, motcle).results
        }
    }
}