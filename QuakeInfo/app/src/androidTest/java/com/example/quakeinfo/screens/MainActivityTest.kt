package com.example.quakeinfo.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.quakeinfo.R
import org.junit.Test

//@RunWith(AndroidJUnit4ClassRunner::class)
//class MainActivityTest {
//
//    @get: Rule
//    var activityScenarioRule : ActivityScenarioRule<MainActivity> = ActivityScenarioRule<MainActivity>
//
//    @Test
//    fun checkActivityVisibility() {
//        onView(withId(R.id.fragment_home1))
//            .check(matches(isDisplayed()))
//    }
//
////    @org.junit.jupiter.api.Test
////    fun onCreate() {
////    }
////
////    @org.junit.jupiter.api.Test
////    fun onSupportNavigateUp() {
////    }
//}