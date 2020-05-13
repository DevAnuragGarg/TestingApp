package com.intact.testingapp.ui.activity

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.intact.testingapp.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DetailActivityTest {

    @get:Rule
    val activityScenarioRule = ActivityTestRule(DetailActivity::class.java)

    @Test
    fun test_activity_launched() {
        onView(
            withText(
                ApplicationProvider.getApplicationContext<Context>().resources.getString(R.string.detail_frag_text)
            )
        ).check(
            matches(isDisplayed())
        )
    }

    @Test
    fun test_recycler_view_visible() {
        onView(withId(R.id.detail_recycler_view)).check(matches(isDisplayed()))

    }


}