package com.example.foodapi.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.foodapi.R
import com.example.foodapi.model.Meal
import com.example.foodapi.viewmodel.FoodUiState


@Composable

fun HomeScreen(
    foodUiState: FoodUiState,
    modifier: Modifier= Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){

}

@Composable

fun LoadingScreen(modifier: Modifier=Modifier){
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(id = R.drawable.loader),
            contentDescription = "Loading")
    }


}

@Composable

fun ErrorScreen(modifier: Modifier=Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.error_load)
            , contentDescription = "Error Loading" )
    }


}

@Composable
fun FoodCard(photo: Meal,modifier: Modifier){
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(photo.strMealThumb)
            .crossfade(true)
            .build()
        ,
        error = painterResource(id = R.drawable.error_404),
        placeholder = painterResource(id = R.drawable.carga),
        contentDescription = stringResource(id = R.string.food_image),
        contentScale = ContentScale.Fit,
        modifier =   modifier
    )

}

@Composable
fun RecipeShowScreen(
    recipe: Meal,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(200.dp),
        modifier = modifier.padding(horizontal = 4.dp),
        contentPadding = contentPadding
    ) {
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                // Display food image
                FoodCard(photo = recipe, modifier = Modifier.weight(1f))

                // Display recipe title
                /*Text(
                    text = recipe.strMeal,

                    fontSize = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp, start = 8.dp, end = 8.dp)
                )*/

                // Display recipe instructions
                Text(
                    text = recipe.strInstructions,
                    modifier = Modifier.padding(horizontal = 8.dp),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

// PONER LAS CADENA DE INSTRUCCIONES DE RECETA
// URL DE YOUTUBE
// INGREDIENTES
// INVESTIGAR DE LA API