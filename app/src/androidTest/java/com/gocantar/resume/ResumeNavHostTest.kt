package com.gocantar.resume

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.filterToOne
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.gocantar.resume.ui.ResumeActivityContent
import com.gocantar.resume.ui.components.models.NavigationBarComposable
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ResumeNavHostTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            ResumeActivityContent(navController = navController)
        }
    }

    @Test
    fun given_first_start_then_home_should_be_the_start_route() {

        composeTestRule
            .onNodeWithTag("home-screen")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithTag("navigation-bar")
            .onChildren()
            .filterToOne(hasTestTag(NavigationBarComposable.Home.route))
            .assertIsSelected()
    }
}