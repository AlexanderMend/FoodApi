package com.example.foodapi.model

import kotlinx.serialization.Serializable

@Serializable
data class RecipeFood(
    val meals: List<Meal>
)

@Serializable
data class Meal(
    val strMeal: String,
    val strInstructions: String,
    val strMealThumb: String,
)
