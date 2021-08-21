package dev.farhanroy.telegramclone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Attachment
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.material.icons.outlined.Mic
import androidx.compose.material.icons.outlined.MicNone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.skydoves.landscapist.glide.GlideImage
import dev.farhanroy.telegramclone.ui.components.PeerBubble
import dev.farhanroy.telegramclone.ui.components.UserBubble
import dev.farhanroy.telegramclone.utils.DataDummy

@Composable
fun ChatDetailScreen(navController: NavController, index: Int) {
    val chat = DataDummy.listChat[index]
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(Modifier.padding(vertical = 4.dp)) {
                        GlideImage(
                            imageModel = chat.imageUrl,
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(45.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(Modifier.padding(start = 16.dp)) {
                            Text(text = chat.name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(1.dp))
                            Text(
                                text = "Last screen recently",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Light
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    Icon(Icons.Default.MoreVert, contentDescription = null)
                },
            )
        },
        backgroundColor = Color(0xffC7D9E9),
        bottomBar = { MessageEditBox() },
        content = { MessageList() }
    )
}

@Composable
fun MessageList() {
    val listMessage = DataDummy.listMessage

    LazyColumn {
        items(listMessage.size) { index ->
            Spacer(modifier = Modifier.height(8.dp))
            if (listMessage[index].isPeer) {
                PeerBubble(listMessage[index])
            } else {
                UserBubble(listMessage[index])
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}


@Composable
fun MessageEditBox() {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .background(Color.White)
            .padding(8.dp)
            .fillMaxWidth()
    ) {

        Icon(
            imageVector = Icons.Outlined.EmojiEmotions,
            contentDescription = null,
            tint = Color.LightGray,
            modifier = Modifier.padding(8.dp)
        )
        BasicTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 8.dp)
        )
        Icon(
            Icons.Outlined.Attachment,
            tint = Color.LightGray,
            modifier = Modifier.padding(8.dp),
            contentDescription = null
        )
        Icon(
            Icons.Outlined.MicNone,
            tint = Color.LightGray,
            modifier = Modifier.padding(8.dp),
            contentDescription = null
        )
    }
}