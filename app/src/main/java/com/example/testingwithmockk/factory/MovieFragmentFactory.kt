package com.example.testingwithmockk.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.testingwithmockk.data.source.MoviesDataSource
import com.example.testingwithmockk.ui.movie.DirectorsFragment
import com.example.testingwithmockk.ui.movie.MovieDetailFragment
import com.example.testingwithmockk.ui.movie.StarActorsFragment

class MovieFragmentFactory(
    private val moviesDataSource: MoviesDataSource? = null
) : FragmentFactory() {

    private val TAG: String = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String) =

        when (className) {

            MovieDetailFragment::class.java.name -> {
                if (moviesDataSource != null
                ) {
                    MovieDetailFragment(
                        moviesDataSource
                    )
                } else {
                    super.instantiate(classLoader, className)
                }
            }

            DirectorsFragment::class.java.name -> {
                DirectorsFragment()
            }

            StarActorsFragment::class.java.name -> {
                StarActorsFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }
}
