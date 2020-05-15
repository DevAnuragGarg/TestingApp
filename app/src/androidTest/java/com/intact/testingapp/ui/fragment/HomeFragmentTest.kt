package com.intact.testingapp.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.intact.testingapp.R
import com.intact.testingapp.pojo.DummyMovies.THE_RUNDOWN
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeFragmentTest {

    @Test
    fun test_home_detail_visible() {
        val movie = THE_RUNDOWN
        val bundle = Bundle()
        bundle.putInt("movie_id", movie.id)

        val scenario = launchFragmentInContainer<HomeFragment>(
            bundle,
            factory = BaseFragmentFactory()
        )

        onView(withText(ApplicationProvider.getApplicationContext<Context>().resources.getString(R.string.settings_label))).check(
            matches(isDisplayed())
        )

        onView(withId(R.id.movie_title)).check(matches(withText(movie.title)))
    }

    @Test
    fun test_movie_title() {
        val movie = THE_RUNDOWN
        val bundle = Bundle()
        bundle.putInt("movie_id", movie.id)

        val scenario = launchFragmentInContainer<HomeFragment>(
            bundle,
            factory = BaseFragmentFactory()
        )

        onView(withText(ApplicationProvider.getApplicationContext<Context>().resources.getString(R.string.settings_label))).check(
            matches(isDisplayed())
        )

        onView(withId(R.id.movie_title)).check(matches(withText(movie.title)))
    }

    @Test
    fun test_movie_description() {
        val movie = THE_RUNDOWN
        val bundle = Bundle()
        bundle.putInt("movie_id", movie.id)

        val scenario = launchFragmentInContainer<HomeFragment>(
            bundle,
            factory = BaseFragmentFactory()
        )

        onView(withText(ApplicationProvider.getApplicationContext<Context>().resources.getString(R.string.settings_label))).check(
            matches(isDisplayed())
        )

        onView(withId(R.id.movie_description)).check(matches(withText(movie.description)))
    }
}