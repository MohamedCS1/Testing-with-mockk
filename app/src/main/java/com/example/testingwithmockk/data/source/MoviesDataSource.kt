package com.example.testingwithmockk.data.source

import com.example.testingwithmockk.data.Movie

interface MoviesDataSource {
    fun getMovie(movieId: Int): Movie?
}