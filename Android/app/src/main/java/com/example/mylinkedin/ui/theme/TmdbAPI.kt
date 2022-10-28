package com.example.mylinkedin.ui.theme

import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbAPI {
    @GET("search/movie")
    suspend fun getFilmParMotCle(@Query("api_key") apikey : String,@Query(" query") motcle : String) : TMBDresult
}