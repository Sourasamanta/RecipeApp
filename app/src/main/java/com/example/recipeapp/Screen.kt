package com.example.recipeapp

sealed class Screen(val route: String) {
    object RecipeScreen : Screen("recipe_screen")
    object CategoryDetailScreen : Screen("category_detail_screen")


}