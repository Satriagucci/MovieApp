package com.example.jetsubmission.data

import com.example.jetsubmission.model.MovieData
import com.example.jetsubmission.model.MovieData.movies
import com.example.jetsubmission.model.MovieList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MovieRepository {
    private val movie = mutableListOf<MovieList>()

    init {
        if (movie.isEmpty()) {
            movies.forEach {
                movie.add(MovieList(it, 0))
            }
        }
    }

    fun getAllData(): Flow<List<MovieList>>{
        return flowOf(movie)
    }

    fun getById(id: Long): MovieList {
        return movie.first {
            it.movie.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(): MovieRepository =
            instance ?: synchronized(this) {
                MovieRepository().apply {
                    instance = this
                }
            }
    }
}