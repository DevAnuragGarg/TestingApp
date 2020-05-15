package com.intact.testingapp.data

import com.intact.testingapp.pojo.DummyMovies.INFINITY_WAR
import com.intact.testingapp.pojo.DummyMovies.THE_RUNDOWN
import com.intact.testingapp.pojo.Movie

object MoviesRemoteDataSource: MovieDataSource {

    private var MOVIES_REMOTE_DATA = LinkedHashMap<Int, Movie>(2)

    init {
        addMovie(INFINITY_WAR)
        addMovie(THE_RUNDOWN)
    }

    override fun getMovie(movieId: Int): Movie? {
        return MOVIES_REMOTE_DATA[movieId]
    }

    private fun addMovie(movie: Movie){
        MOVIES_REMOTE_DATA.put(movie.id, movie)
    }


}