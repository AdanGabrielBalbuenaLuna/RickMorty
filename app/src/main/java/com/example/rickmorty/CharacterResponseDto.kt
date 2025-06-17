package com.example.rickmorty

data class CharacterResponse(
    val info: Info,
    val results: List<CharacterDto>
)