package com.gocantar.resume.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsSelectable
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.composable
import androidx.navigation.createGraph
import androidx.navigation.testing.TestNavHostController
import com.gocantar.resume.components.mocks.TestNavHost
import com.gocantar.resume.ui.components.NavigationBar
import com.gocantar.resume.ui.components.models.NavigationBarComposable
import com.gocantar.resume.ui.theme.AppTheme
import com.gocantar.resume.ui.theme.Purple400
import com.gocantar.resume.ui.theme.Purple700
import kotlinx.coroutines.delay
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationBarTest {

    @get:Rule
    val rule = createComposeRule()

    lateinit var navController: TestNavHostController

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Before
    fun setUp() {
        rule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            AppTheme {
                Scaffold(
                    content = { TestNavHost(navController = navController) },
                    bottomBar = { NavigationBar(navController) }
                )
            }
        }
    }

    @Test
    fun given_navigation_bar_when_start_route_is_selected_then_should_has_the_firs_item_selected() {
        rule.onNodeWithTag(NavigationBarComposable.Home.route)
            .assertIsDisplayed()
            .assertIsSelected()
        rule.onNodeWithTag(NavigationBarComposable.Experience.route)
            .assertIsDisplayed()
            .assertIsNotSelected()
        rule.onNodeWithTag(NavigationBarComposable.Studies.route)
            .assertIsDisplayed()
            .assertIsNotSelected()
        rule.onNodeWithTag(NavigationBarComposable.Portfolio.route)
            .assertIsDisplayed()
            .assertIsNotSelected()
    }

    @Test
    fun given_navigation_bar_when_select_experience_then_should_has_the_second_item_selected() {
        rule.onNodeWithTag(NavigationBarComposable.Experience.route)
            .assertIsDisplayed()
            .performClick()
            .assertIsSelected()
        rule.onNodeWithTag(NavigationBarComposable.Home.route)
            .assertIsDisplayed()
            .assertIsNotSelected()
        rule.onNodeWithTag(NavigationBarComposable.Studies.route)
            .assertIsDisplayed()
            .assertIsNotSelected()
        rule.onNodeWithTag(NavigationBarComposable.Portfolio.route)
            .assertIsDisplayed()
            .assertIsNotSelected()
    }
}
