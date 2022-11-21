package com.example.mylinkedin.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {
    val movies = MutableStateFlow<List<Movie>>(listOf())
    val movie = MutableStateFlow<Movie?>(null)
    val motcle= String

    private val apikey = "fb07b2b57a58124103dc89332ac95ee7"

    private val service = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(TmdbAPI::class.java)


    fun searchMovies(motcle: String) {
        viewModelScope.launch {
            movies.value = service.searchmovie(apikey, motcle).results
        }
    }
    fun lastMovie() {
        viewModelScope.launch {
            movies.value = service.lastMovie(apikey, "fr").results
        }
    }
    fun lastPersonne(){
        viewModelScope.launch {
            personnes.value = service.lastPersonne(apikey,"fr").results
        }
    }
    fun getMovieDetail(id: String) {
        viewModelScope.launch {
            service.movieDetails(id,apikey);
        }
    }
    fun getMovieParMotCle(motcle: String) {
        viewModelScope.launch {
            service.getMovieParMotCle(motcle,apikey);
        }
    }



    val series = MutableStateFlow<List<Serie>>(listOf())
    val serie = MutableStateFlow<Serie?>(null)
    val oneserie = MutableStateFlow<DetailSerie?>(null)

    val personnes = MutableStateFlow<List<Personnes>>(listOf())
    val personne = MutableStateFlow<Personnes?>(null)

    fun SearchSeries(motcle: String) {
        viewModelScope.launch {
            series.value = service.searchSerie(motcle, apikey).results
        }
    }

    fun lastSerie() {
        viewModelScope.launch {
            series.value = service.lastSerie(apikey, "fr").results
        }
    }
    fun getSerieDetail(id: String) {
        viewModelScope.launch {
            service.SerieDetails(id,apikey);
        }
    }

    fun oneSerie(id: String) {
        viewModelScope.launch {
            oneserie.value = service.oneSerie(id, apikey, "credits")
        }
    }

    fun getPersonneDetail(id: String) {
        viewModelScope.launch {
            service.detailPersonne(id, apikey)
        }
    }
    fun SearchPersonne(motcle: String) {
        viewModelScope.launch {
            personnes.value = service.searchPersonne(motcle,apikey).results
        }
    }
}