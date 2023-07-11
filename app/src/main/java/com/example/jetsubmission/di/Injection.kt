package com.example.jetsubmission.di

import com.example.jetsubmission.data.MovieRepository

object Injection {
    fun provideRepository(): MovieRepository {
        return MovieRepository.getInstance()
    }
}