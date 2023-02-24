package com.example.testingwithmockk.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.testingwithmockk.R
import com.example.testingwithmockk.data.Movie
import com.example.testingwithmockk.data.source.MoviesDataSource
import com.example.testingwithmockk.factory.MovieFragmentFactory
import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
internal class MovieDetailFragmentTest
{
    @Test
    fun testIsMovieDataVisible()
    {
        val movie = Movie(
            0,
            "Avengers: Infinity War",
            "https://nyc3.digitaloceanspaces.com/open-api-spaces/open-api-static/blog/1/Infinity_War-infinity_war.png",
            "The Avengers and their allies must be willing to sacrifice all in an attempt to " +
                    "defeat the powerful Thanos before his blitz of devastation and ruin puts an end to " +
                    "the universe.",
            arrayListOf("Anthony Russo", "Joe Russo"),
            arrayListOf("Robert Downey Jr.", "Chris Hemsworth", "Mark Ruffalo", "+ more...")
        )

//        val moviesDataSource = mockk<MoviesDataSource>()
//        every {
//            moviesDataSource.getMovie(movie.id)
//        } returns movie
//
        val fragmentFactory = MovieFragmentFactory()

        val bundle = Bundle()
        bundle.putInt("movie_id" ,movie.id)

        launchFragmentInContainer<MovieDetailFragment>(fragmentArgs = bundle , factory = fragmentFactory)

        onView(withId(R.id.movie_title)).check(matches(withText(movie.title)))
        onView(withId(R.id.movie_description)).check(matches(withText(movie.description)))
    }
}