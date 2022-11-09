package com.example.mylinkedin.ui.theme

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbAPI {
    @GET("movie/{movie_id}")
    suspend fun movieDetails(@Path("movie_id") id: String): Movie

    @GET("search/movie")
    suspend fun getFilmParMotCle(@Query("api_key") apikey : String,@Query(" query") motcle : String) : TMBDResult

    @GET("/trending/movie/week")
    suspend fun lastMovie(@Query("api_key") apikey: String, @Query("language")language: String): TMBDResult

    @GET("/movie/{id}")
    suspend fun oneMovie (@Path("id") id:String, @Query("api_key") apikey: String, @Query("append_to_response") credits: String, @Query("language")language: String): DetailFilm


    @GET("/search/tv")
    suspend fun getSerieParMotCle(@Query("query") motcle: String,@Query("api_key") apikey: String, @Query("language")language: String): TmdbResultSeries

    @GET("/trending/tv/week")
    suspend fun lastSerie(@Query("api_key") apikey: String, @Query("language")language: String): TmdbResultSeries

    @GET("/tv/{id}")
    suspend fun oneSerie (@Path("id") id:String, @Query("api_key") apikey: String, @Query("append_to_response") credits: String, @Query("language")language: String): DetailSerie



}