package com.gocantar.resume.data

import com.gocantar.resume.R
import com.gocantar.resume.ui.components.models.SkillsPanelComposable

object Skills {

    val items: List<SkillsPanelComposable>
        get() = listOf(Android, Code, UI, Personal)

    val Android = SkillsPanelComposable(
        icon = R.drawable.ic_android,
        title = "Android",
        skills = listOf("Android SDK", "Wear OS", "Android Things")
    )
    val Code = SkillsPanelComposable(
        icon = R.drawable.ic_code,
        title = "Codigo",
        skills = listOf("Clean Architecture", "Kotlin", "Test Driven Development")
    )
    val UI = SkillsPanelComposable(
        icon = R.drawable.ic_pallete,
        title = "Interfaz de usuario",
        skills = listOf("Material Design", "Sketch")
    )

    val Personal = SkillsPanelComposable(
        icon = R.drawable.ic_person,
        title = "Personales",
        skills = listOf("Trabajo en equipo", "Capacidad de analisis", "Resolución de problemas")
    )

}