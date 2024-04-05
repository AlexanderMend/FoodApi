package com.example.foodapi.data

import com.example.foodapi.model.Meal
import com.example.foodapi.network.FoodApi

interface FoodRecipeRepository{
    suspend fun getFoodRecipe(): Meal
}

class NetworkFoodRecipeRepository: FoodRecipeRepository{
    override suspend fun getFoodRecipe(): Meal {
        return FoodApi.retrofitService.getRecipe()
    }
}