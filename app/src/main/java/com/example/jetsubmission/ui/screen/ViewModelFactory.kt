package com.example.jetsubmission.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.jetsubmission.data.MovieRepository
import com.example.jetsubmission.ui.screen.detail.DetailViewModel
import com.example.jetsubmission.ui.screen.home.HomeViewModel

class ViewModelFactory(private val repository: MovieRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create(modelClass: Class<T>): T = when {
        modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository) as T
        modelClass.isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(repository) as T
        else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
    }
}