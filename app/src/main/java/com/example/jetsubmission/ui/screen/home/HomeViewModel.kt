package com.example.jetsubmission.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetsubmission.data.MovieRepository
import com.example.jetsubmission.model.MovieList
import com.example.jetsubmission.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: MovieRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<MovieList>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<MovieList>>>
        get() = _uiState

    fun getAllData() {
        viewModelScope.launch {
            repository.getAllData()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { movieList ->
                    _uiState.value = UiState.Success(movieList)
                }
        }
    }

}