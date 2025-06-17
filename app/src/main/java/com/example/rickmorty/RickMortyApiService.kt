package com.example.rickmorty

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyApiService {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): Response<CharacterResponse>
}