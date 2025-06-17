package com.example.rickmorty

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("id")
    val characterId: Int,

    @SerializedName("name")
    val fullName: String,

    @SerializedName("status")
    val lifeStatus: String,

    @SerializedName("species")
    val speciesType: String,

    @SerializedName("type")
    val customType: String,

    @SerializedName("gender")
    val genderIdentity: String,

    @SerializedName("origin")
    val placeOfOrigin: Origin,

    @SerializedName("location")
    val currentLocation: Location,

    @SerializedName("image")
    val imageUrl: String,

    @SerializedName("episode")
    val episodeUrls: List<String>,

    @SerializedName("url")
    val characterApiUrl: String,

    @SerializedName("created")
    val createdAt: String
)

data class Origin(
    @SerializedName("name")
    val originName: String,

    @SerializedName("url")
    val originUrl: String
)

data class Location(
    @SerializedName("name")
    val locationName: String,

    @SerializedName("url")
    val locationUrl: String
)
