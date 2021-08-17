package dev.farhanroy.telegramclone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
        drawerContent = { AppDrawer() },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Edit, contentDescription = null, tint = Color.White)
            }
        },
        scaffoldState = scaffoldState
    ) {
        ChatList(navController)
    }
}

@Composable
fun ChatList(navController: NavHostController) {
    val listChat = DataDummy.listChat
    LazyColumn {
        items(listChat.size) { index -> ChatItem(listChat[index], onClick = {
            navController.navigate(Routes.ChatDetail.route + "/$index")
        }) }
    }
}

@Composable
fun ChatItem(chat: Chat, onClick: () -> Unit) {
    Row(
        Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .clickable { onClick() }) {
        GlideImage(
            imageModel = chat.imageUrl,
            modifier = Modifier
                .clip(CircleShape)
                .size(56.dp),
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .padding(horizontal = 14.dp)
                .weight(7f)) {
            Text(chat.name, fontWeight = FontWeight.SemiBold, fontSize = 17.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                chat.lastMessage ?: "",
                maxLines = 1,
                fontSize = 16.sp,
                color = Color.Gray
            )
        }

        Column(Modifier.weight(1f)) {
            Text(chat.time, fontWeight = FontWeight.Light, fontSize = 13.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = chat.newChatSize.toString(),
                color = Color.White,
                fontSize = 13.sp,
                modifier = Modifier
                    .background(Color.LightGray, shape = RoundedCornerShape(4.dp))
                    .padding(4.dp),

            )
        }
    }
}




