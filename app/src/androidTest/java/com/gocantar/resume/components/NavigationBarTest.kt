package com.gocantar.resume.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.gocantar.resume.ui.components.NavigationBar
import com.gocantar.resume.ui.components.models.NavigationBarComposable
import com.gocantar.resume.ui.theme.AppTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class NavigationBarTest {

    @get:Rule
    val rule = createComposeRule()

    @Test
    fun given_navigation_bar_when_home_route_is_selected_then_should_has_the_home_item_selected() {
        rule.setContent {
            AppTheme {
                NavigationBar(currentRoute = NavigationBarComposable.Home.route)
            }
        }
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
    fun given_navigation_bar_when_select_experience_then_should_emit_that_experiences_click() {
        rule.setContent {
            AppTheme {
                NavigationBar(
                    currentRoute = NavigationBarComposable.Home.route,
                    onClick = { assertEquals(NavigationBarComposable.Experience.route, it) }
                )
            }
        }
        rule.onNodeWithTag(NavigationBarComposable.Experience.route)
            .assertIsDisplayed()
            .performClick()
    }
}
