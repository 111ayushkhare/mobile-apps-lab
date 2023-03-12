package com.example.testsample

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get:Rule var activityScenarioRule = activityScenarioRule<MainActivity>()

    // Check if `Main Activity` is displayed/visible to the user
    @Test
    fun checkActivityVisibility() {
        onView(withId(R.id.main_activity)).check(matches(isDisplayed()))
    }

    // Check if text in MainActivity is visible we want
    @Test
    fun chekTextVisibility() {
        onView(withId(R.id.textMain)).check(matches(isDisplayed()))
    }

    // Check if text in MainActivity is matching as to actual
    @Test
    fun checkTextAsExpected() {
        onView(withId(R.id.textMain)).check(matches(withText("Hello User")))
    }

    // Button Click Testing
    @Test
    fun checkNavigation() {
        onView(withId(R.id.buttonMain)).perform(click())
        onView(withId(R.id.second_activity)).check(matches(isDisplayed()))
    }

    // back button testing
    @Test
    fun checkBackNavigation() {
        onView(withId(R.id.buttonMain)).perform(click())
        onView(withId(R.id.second_activity)).check(matches(isDisplayed()))

        Espresso.pressBack()
        onView(withId(R.id.main_activity)).check(matches(isDisplayed()))
    }
}