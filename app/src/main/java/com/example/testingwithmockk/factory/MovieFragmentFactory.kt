package com.example.testingwithmockk.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.testingwithmockk.ui.movie.DirectorsFragment
import com.example.testingwithmockk.ui.movie.MovieDetailFragment
import com.example.testingwithmockk.ui.movie.StarActorsFragment

class MovieFragmentFactory:FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        when(className){

            MovieDetailFragment::class.java.name -> {
                MovieDetailFragment()
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
        return super.instantiate(classLoader, className)
    }
}