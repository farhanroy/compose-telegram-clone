package dev.farhanroy.telegramclone

sealed class Routes(val route: String) {
    object Chat : Routes("chat")
    object ChatDetail : Routes("chat/detail")
}
