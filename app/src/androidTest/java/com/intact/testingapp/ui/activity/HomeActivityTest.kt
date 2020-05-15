package com.intact.testingapp.ui.activity

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.intact.testingapp.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 *  This tells JUnit to run the tests inside of AndroidJUnit4 instead of the
 *  runner built into JUnit. AndroidJUnit4ClassRunner is a test runner that runs JUnit
 *  style tests on Android devices.
 *
 *  as we are using helper dependencies for android x we no need to write the activity rule.
 *  if not added need to write the rule
 *  @Rule val mActivityRule : ActivityTestRule<OrderActivity> = ActivityTestRule<>(OrderActivity.class)
 *  androidTestImplementation 'androidx.test:rules:1.2.0'
 *
 *  ActivityScenario is a cross-platform API that you can use in local unit tests and on-device
 *  integration tests alike. On a real or virtual device, ActivityScenario provides thread safety,
 *  synchronizing events between your test's instrumentation thread and the thread that runs your
 *  activity under test. ActivityScenario provides APIs to start and drive an Activity’s lifecycle
 *  state for testing. It works with arbitrary activities and works consistently across different
 *  versions of the Android framework. ActivityScenario offers a launch() method which accepts
 *  either a class reference or an Intent used to launch that Activity. KTX version offers a better
 *  alternative in Kotlin though i.e. launchActivity() inline function
 *
 *  ActivityScenario does’t clean up device state automatically and may leave the activity keep
 *  running after the test finishes. Call close() in your test to clean up the state or use
 *  try-with-resources statement. This is optional but highly recommended to improve the stability
 *  of your tests.
 *  ActivityScenarioRule launches a given activity before the test starts and closes after the test.
 *  You can access to scenario interface via getScenario() method. You may finish your activity
 *  manually in your test, it will not cause any problems and this rule does nothing after the test
 *  in such cases.
 *
 *  scroll to is not working for the recycler view or scroll view. In place perform an action
 *  to swipe up which works in most of the cases.
 *
 *  You can also use withText in place of withId which will help to check the strings
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityTest {

    @get:Rule
    val rule = ActivityScenarioRule(HomeActivity::class.java)

    @get:Rule
    val intentsTestRule = IntentsTestRule(HomeActivity::class.java)

    @Test
    fun test_home_hello_world() {
        onView(withId(R.id.hello_world_tv)).check(matches(withText("Hello World!")))
    }

    @Test
    fun test_detail_activity_intent() {
        val expectedIntent: Matcher<Intent> = allOf(
            IntentMatchers.hasExtra("FirstArg", "Anurag")
        )

        val value: Float = 10F
        val abc = value + 10
    }

    @Test
    fun test_home_next_activity_button() {
        onView(withId(R.id.next_button)).check(matches(isDisplayed()))
    }

    @Test
    fun test_home_launch_next_activity_button() {
        onView(withId(R.id.next_button)).perform(click())
        onView(withId(R.id.detail_label_tv)).check(
            matches(
                withText(
                    ApplicationProvider.getApplicationContext<Context>().resources.getString(
                        R.string.detail_frag_text
                    )
                )
            )
        )
    }

    @Test
    fun testing_detail_back_navigation() {
        onView(withId(R.id.next_button)).perform(click())
        onView(withId(R.id.detail_label_tv)).check(
            matches(
                withText(
                    ApplicationProvider.getApplicationContext<Context>().resources.getString(
                        R.string.detail_frag_text
                    )
                )
            )
        )

        pressBack()

        onView(withId(R.id.hello_world_tv)).check(matches(isDisplayed()))
    }
}