package dev.farhanroy.telegramclone.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ChatDetailScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                        Row {
                           GlideImage(imageModel = "")
                           Column {
                               Text(text = "")
                               Text(text = "")
                           }
                        }
                },
                navigationIcon = { IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = null)
                } },
                actions = {
                    Icon(Icons.Default.MoreVert, contentDescription = null)
                }
            )
        }
    ) {

    }
}