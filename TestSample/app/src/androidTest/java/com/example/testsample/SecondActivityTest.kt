package com.example.testsample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import org.junit.Rule
import org.junit.Test

class SecondActivityTest {

    @get: Rule
    var activityScenarioRule = activityScenarioRule<SecondActivity>()

    // checking activity visibility
    @Test
    fun checkActivityDisplay() {
        onView(withId(R.id.second_activity)).check(matches(isDisplayed()))
    }

    // Check if text in Second Activity is matching as to actual
    @Test
    fun checkTextAsExpected() {
        onView(withId(R.id.textSecond)).check(matches(withText(R.string.draft_email_heading)))
    }

    // Checking layout components visibility
    @Test
    fun checkButtonAndTextVisibility() {
        onView(withId(R.id.textSecond)).check(matches(isDisplayed()))

        onView(withId(R.id.email_addr)).check(matches(isDisplayed()))
        onView(withId(R.id.email_subj)).check(matches(isDisplayed()))
        onView(withId(R.id.email_body)).check(matches(isDisplayed()))

        onView(withId(R.id.buttonSecond)).check(matches(isDisplayed()))
        onView(withId(R.id.buttonSecond2)).check(matches(isDisplayed()))
    }

    // Checking email draft
    @Test
    fun checkMailDraft() {
        onView(withId(R.id.email_addr))
            .perform(typeText("ankit.bhatnagar@searce.com,ayush.khare@searce.com"))
            .check(matches(withText("ankit.bhatnagar@searce.com,ayush.khare@searce.com")))

        onView(withId(R.id.email_subj))
            .perform(typeText("Subject for test email"))
            .check(matches(withText("Subject for test email")))

        onView(withId(R.id.email_body))
            .perform(typeText("This is the body for test email"))
            .check(matches(withText("This is the body for test email")))

        onView(withId(R.id.buttonSecond2)).perform(click())
    }
}