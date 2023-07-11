package com.example.jetsubmission.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetsubmission.di.Injection
import com.example.jetsubmission.model.MovieList
import com.example.jetsubmission.ui.common.UiState
import com.example.jetsubmission.ui.components.MovieItem
import com.example.jetsubmission.ui.screen.ViewModelFactory

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository())),
    navigateToDetail: (Long) -> Unit,
) {

    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let {
        when (it) {
            is UiState.Loading -> {
                viewModel.getAllData()
            }
            is UiState.Success -> {
                HomeContent(
                    movieList = it.data,
                    navigateToDetail = navigateToDetail,
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun HomeContent(
    movieList: List<MovieList>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
    Box(modifier = Modifier) {
        LazyColumn {
            items(movieList) {
                MovieItem(
                    id = it.movie.id,
                    name = it.movie.movie_title,
                    genre = it.movie.movie_genre,
                    description = it.movie.movie_description,
                    image = it.movie.movie_image,
                    navigateToDetail = navigateToDetail,
                )
            }
        }
    }
}

@Composable
fun Content(
    movieList: List<MovieList>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
) {
    
}