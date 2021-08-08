package dev.farhanroy.telegramclone.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import dev.farhanroy.telegramclone.Routes
import dev.farhanroy.telegramclone.ui.components.AppDrawer
import kotlinx.coroutines.launch

@Composable
fun ChatScreen(navController: NavHostController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Telegram") },
                navigationIcon = {
                    IconButton(onClick = {
                    scope.launch { drawerState.open() } }) {
                        Icon(Icons.Default.MoreVert, contentDescription = null)
                    }
                }
            )
        },
        drawerContent = {AppDrawer(drawerState)}
    ) {
        ChatList(onClick = {
            navController.navigate(Routes.ChatDetail.route)
        })
    }
}

@Composable
fun ChatList(onClick: () -> Unit) {
    LazyColumn(
        content = {},
    )
}

