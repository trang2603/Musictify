package com.example.musictify.domain


data class Genre(
    val id: String, val label: String,
    val type: Type
) {

    enum class Type {
        AMBIENT,
        CHILL,
        CLASSICAL,
        DANCE,
        ELECTRONIC,
        METAL,
        RAINY_DAY,
        ROCK,
        PIANO,
        POP,
        SLEEP
    }
}