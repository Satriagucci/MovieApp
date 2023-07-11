package com.example.jetsubmission.ui.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Profile: Screen("profile")
    object Detail: Screen("home/{id}") {
        fun createRoute(id: Long) = "home/$id"
    }
}