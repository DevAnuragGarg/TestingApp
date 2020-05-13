package com.intact.testingapp.ui.fragment

import android.content.Context
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.intact.testingapp.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeFragmentTest {

    @Test
    fun test_home_detail_visible() {
        val scenario = launchFragmentInContainer<HomeFragment>(
            factory = BaseFragmentFactory()
        )

        onView(withText(ApplicationProvider.getApplicationContext<Context>().resources.getString(R.string.settings_label))).check(
            matches(isDisplayed())
        )
    }
}