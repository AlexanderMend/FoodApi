package com.example.foodapi.model

import kotlinx.serialization.Serializable

@Serializable
data class Meal(
    val idMeal: String,
    val strMeal: String,
    val strInstructions: String,
    val strMealThumb: String,
)
