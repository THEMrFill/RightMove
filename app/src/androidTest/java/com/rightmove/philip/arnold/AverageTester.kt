package com.rightmove.philip.arnold

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.rightmove.philip.arnold.di.StartMockedKoin.startMockedKoin
import com.rightmove.philip.arnold.ui.main.MainFragment
import org.junit.*
import org.junit.runner.RunWith
import org.koin.core.context.GlobalContext
import org.koin.core.context.stopKoin

@RunWith(AndroidJUnit4::class)
@LargeTest
class AverageTester {
    fun before(count: Int = 1) {
        if (GlobalContext.getOrNull() != null) {
            stopKoin()
        }
        startMockedKoin(count)
    }

    @Test
    fun checkAverageSingle() {
        before()
        launchFragmentInContainer<MainFragment>()
        Thread.sleep(500)
        onView(withId(R.id.average))
            .check(matches(withText("£1,000,000.00")))
        after()
    }

    @Test
    fun checkAverageTriple() {
        before(3)
        launchFragmentInContainer<MainFragment>()
        Thread.sleep(5000)
        onView(withId(R.id.average))
            .check(matches(withText("£500,000.00")))
        after()
    }

    fun after() {
        stopKoin()
    }
}