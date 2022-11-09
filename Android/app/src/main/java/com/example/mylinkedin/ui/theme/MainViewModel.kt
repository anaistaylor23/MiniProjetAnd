package com.example.mylinkedin.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class MainViewModel : ViewModel() {
    val movies = MutableStateFlow<List<Movie>>(listOf())


    private val apikey = "fb07b2b57a58124103dc89332ac95ee7"

    private val service = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(TmdbAPI::class.java)
    private val onemovie = MutableStateFlow<DetailFilm?>(null)

    fun searchMovies(motcle: String) {
        viewModelScope.launch {
            movies.value = service.getFilmParMotCle(apikey, motcle).results
        }
    }
    fun lastMovie() {
        viewModelScope.launch {
            movies.value = service.lastMovie(apikey, "fr").results
        }
    }

    fun oneMovie(id: String) {
        viewModelScope.launch {
            onemovie.value = service.oneMovie(id, apikey, "credits", "fr")
        }

    }

    val series = MutableStateFlow<List<Serie>>(listOf())
    val oneserie = MutableStateFlow<DetailSerie?>(null)

    val personnes = MutableStateFlow<List<Personnes>>(listOf())
    fun searchSerie(motcle: String) {
        viewModelScope.launch {
            series.value = service.getSerieParMotCle(motcle, apikey, "fr").results
        }
    }

    fun lastSerie() {
        viewModelScope.launch {
            series.value = service.lastSerie(apikey, "fr").results
        }
    }

    fun oneSerie(id: String) {
        viewModelScope.launch {
            oneserie.value = service.oneSerie(id, apikey, "credits", "fr")
        }
    }
}