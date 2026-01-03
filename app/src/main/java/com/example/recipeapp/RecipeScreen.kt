package com.example.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme


    @Composable
    fun RecipeScreen(
        viewState: MainViewModel.RecipeState,
        navigateToDetail: (Category) -> Unit
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            when {
                viewState.loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                viewState.error != null -> {
                    Text(
                        text = "Error: ${viewState.error}",
                        color = Color.Red,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                else -> {
                    CategoryScreen(
                        categories = viewState.list,
                        navigateToDetail = navigateToDetail
                    )
                }
            }
        }
    }
    @Composable
    fun CategoryScreen(
        categories: List<Category>,
        navigateToDetail: (Category) -> Unit
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize()
        ) {
            items(categories) { category ->
                CategoryItem(
                    category = category,
                    navigateToDetail = navigateToDetail
                )
            }
        }
    }

    @Composable
    fun CategoryItem(
        category: Category,
        navigateToDetail: (Category) -> Unit
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .clickable { navigateToDetail(category) },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(category.strCategoryThumb),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1f)
            )

            Text(
                text = category.strCategory,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }


