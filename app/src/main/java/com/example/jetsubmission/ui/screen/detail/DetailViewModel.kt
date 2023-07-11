package com.example.jetsubmission.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetsubmission.data.MovieRepository
import com.example.jetsubmission.model.MovieList
import com.example.jetsubmission.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: MovieRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<MovieList>> = MutableStateFlow(UiState.Loading)

    val uiState: StateFlow<UiState<MovieList>>
        get() = _uiState

    fun getById(id: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getById(id))
        }
    }
}