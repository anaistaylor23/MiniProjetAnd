package com.example.mylinkedin.ui.theme

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbAPI {
    @GET("movie/{movie_id}")
    suspend fun movieDetails(@Path("movie_id")id: String, @Query("api_key") apikey: String,@Query("append_to_response")appendToResponse: String): DetailFilm

    @GET("search/movie")
    suspend fun searchmovie(@Query("api_key") apikey : String,@Query(" query") motcle : String) : TMBDResult

    @GET("trending/movie/week")
    suspend fun lastMovie(@Query("api_key") apikey: String, @Query("language")language: String): TMBDResult

    @GET("search/tv")
    suspend fun searchSerie (@Query("query") motcle: String,@Query("api_key") apikey: String): TmdbResultSeries

    @GET("trending/tv/week")
    suspend fun lastSerie(@Query("api_key") apikey: String, @Query("language")language: String): TmdbResultSeries

    @GET("trending/person/week")
    suspend fun lastPersonne(@Query("api_key") apikey: String, @Query("language")language: String): TmdbResultPersonne

    @GET("tv/{id}")
    suspend fun SerieDetails(@Path("id") id: String, @Query("api_key")api_key: String): DetailSerie

    @GET("person/{id}?language=fr-FR")
    suspend fun detailPersonne(@Path("id") id: String, @Query("api_key") api_key: String): TmdbResultPersonne

    @GET("search/person?language=fr-FR")
    suspend fun searchPersonne(@Query("query") search: String, @Query("api_key") api_key: String): TmdbResultPersonne




}