package dev.farhanroy.telegramclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.farhanroy.telegramclone.ui.screens.ChatDetailScreen
import dev.farhanroy.telegramclone.ui.screens.ChatScreen
import dev.farhanroy.telegramclone.ui.screens.SettingScreen
import dev.farhanroy.telegramclone.ui.theme.TelegramCloneTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelegramCloneTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    CompositionLocalProvider(Router provides navController) {
                        MainScreen()
                    }

                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = Router.current
    NavHost(navController = navController, startDestination = Routes.Chat.route) {

        // First route : Chat
        composable(Routes.Chat.route) {
            ChatScreen()
        }

        // Setting route
        composable(Routes.Setting.route) {
            SettingScreen()
        }

        // Another Route : Chat detail
        composable(Routes.ChatDetail.route + "/{id}") {
            val id = it.arguments?.getInt("id")
           ChatDetailScreen(index = id ?: 0)
        }
    }
}