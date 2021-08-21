package dev.farhanroy.telegramclone

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController


val Router = compositionLocalOf<NavHostController> { error("No active user found!") }


sealed class Routes(val route: String) {
    object Chat : Routes("chat")
    object ChatDetail : Routes("chat/detail")
    object Setting : Routes("setting")
}
