package com.intact.testingapp.data

import com.intact.testingapp.pojo.Movie

interface MovieDataSource {
    fun getMovie(movieId: Int): Movie?
}