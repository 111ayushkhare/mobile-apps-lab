package com.example.testsample

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(ExampleInstrumentedTest::class,MainActivityTest::class, SecondActivityTest::class)
class ActivityTestSuite