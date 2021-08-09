package dev.farhanroy.telegramclone.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.skydoves.landscapist.glide.GlideImage
import dev.farhanroy.telegramclone.Routes
import dev.farhanroy.telegramclone.ui.components.AppDrawer
import dev.farhanroy.telegramclone.utils.Chat
import dev.farhanroy.telegramclone.utils.DataDummy
import kotlinx.coroutines.launch

@Composable
fun ChatScreen(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Telegram") },
                actions = { Icon(Icons.Default.Search, contentDescription = null) },
                navigationIcon = { IconButton(onClick = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = null)
                } }
            )
        },
        drawerContent = { Text(text = "")},
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Edit, contentDescription = null)
            }
        },
        scaffoldState = scaffoldState
    ) {
        ChatList(onClick = {
            navController.navigate(Routes.ChatDetail.route)
        })
    }
}

@Composable
fun ChatList(onClick: () -> Unit) {
    val listChat = DataDummy.listChat
    LazyColumn {
        items(listChat.size) { index -> ChatItem(listChat[index], onClick) }
    }
}

@Composable
fun ChatItem(chat: Chat, onClick: () -> Unit) {
    Row(
        Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onClick() }) {
        GlideImage(
            imageModel = chat.imageUrl,
            modifier = Modifier
                .clip(CircleShape)
                .size(64.dp),
            contentScale = ContentScale.Crop
        )
        Column(Modifier.padding(horizontal = 8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(chat.name, fontWeight = FontWeight.SemiBold, fontSize = 17.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(chat.time, fontWeight = FontWeight.Light, fontSize = 12.sp)
            }
            Text(
                chat.lastMessage ?: "",
                maxLines = 1,
                fontSize = 15.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(16.dp))
            Divider(color = Color(0xFFebebeb))
        }
    }
}




