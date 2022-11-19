package com.gocantar.resume.data

import com.gocantar.resume.R
import com.gocantar.resume.ui.components.models.SkillComposable

object Skills {
    object Hard {
        val items: List<SkillComposable>
            get() = listOf(
                AndroidSDK,
                WearOS,
                AndroidThings,
                AndroidStudio,
                ClearArchitecture,
                Kotlin,
                TestDrivenDevelopment,
                Sketch
            )
        private val AndroidSDK = SkillComposable(
            icon = R.drawable.ic_android,
            title = "Android SDK",
            value = 10
        )
        private val WearOS = SkillComposable(
            icon = R.drawable.ic_wear,
            title = "Wear OS",
            value = 8
        )
        private val AndroidThings = SkillComposable(
            icon = R.drawable.ic_android,
            title = "Android Things",
            value = 6
        )
        private val AndroidStudio = SkillComposable(
            icon = R.drawable.ic_android,
            title = "Android Studio",
            value = 10
        )
        private val ClearArchitecture = SkillComposable(
            icon = R.drawable.ic_code,
            title = "Clean Architecture",
            value = 10
        )
        private val Kotlin = SkillComposable(
            icon = R.drawable.ic_code,
            title = "Kotlin",
            value = 10
        )
        private val TestDrivenDevelopment = SkillComposable(
            icon = R.drawable.ic_code,
            title = "Testing",
            value = 10
        )
        private val Sketch = SkillComposable(
            icon = R.drawable.ic_picture,
            title = "Sketch",
            value = 6
        )
    }
}