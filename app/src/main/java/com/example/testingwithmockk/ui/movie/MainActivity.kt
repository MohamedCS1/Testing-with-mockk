package com.example.testingwithmockk.ui.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testingwithmockk.R
import com.example.testingwithmockk.data.source.MoviesDataSource
import com.example.testingwithmockk.data.source.MoviesRemoteDataSource
import com.example.testingwithmockk.factory.MovieFragmentFactory

class
MainActivity : AppCompatActivity() {

    lateinit var moviesDataSource: MoviesDataSource
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDependencies()
        supportFragmentManager.fragmentFactory = MovieFragmentFactory(moviesDataSource)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        if(supportFragmentManager.fragments.size == 0){
            val movieId = 0
            val bundle = Bundle()
            bundle.putInt("movie_id", movieId)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieDetailFragment::class.java, bundle)
                .commit()
        }
    }

    private fun initDependencies(){
        moviesDataSource = MoviesRemoteDataSource()
    }
}