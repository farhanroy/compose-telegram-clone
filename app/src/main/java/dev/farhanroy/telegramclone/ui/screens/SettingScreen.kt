package dev.farhanroy.telegramclone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.glide.GlideImage
import dev.farhanroy.telegramclone.Router

@Composable
fun SettingScreen() {
    Scaffold(
        topBar = { SettingTopBar() },
        content = { SettingBody() },
    )
}

@Composable
fun SettingTopBar() {
    val router = Router.current
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { router.navigateUp() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        title = {
            Row(Modifier.padding(vertical = 4.dp)) {
                GlideImage(
                    imageModel = "https://randomuser.me/api/portraits/men/12.jpg",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(45.dp),
                    contentScale = ContentScale.Crop
                )
                Column(Modifier.padding(start = 16.dp)) {
                    Text(text = "Farhan Roy", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(
                        text = "Online",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        },

        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.Search, contentDescription = null)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.MoreVert, contentDescription = null)
            }
        }
    )
}


@Composable
fun SettingBody() {
    Column(Modifier.background(color = Color.LightGray)) {
        BodyAccount()
        Spacer(modifier = Modifier.height(8.dp))
        BodySetting()
        Spacer(modifier = Modifier.height(8.dp))
        BodyHelp()
    }
}

@Composable
fun BodyAccount() {
    Card {
        Column(Modifier.padding(16.dp)) {
            Text(text = "Account", color = MaterialTheme.colors.primary)
            Spacer(modifier = Modifier.height(16.dp))
            AccountText(text1 = "+62852341212", text2 = "Tap to change phone number")
            AccountText(text1 = "@roy", text2 = "Username")
            AccountText(text1 = "Graphic", text2 = "bio")
        }
    }
}

@Composable
fun BodySetting() {
    Card {
        Column(Modifier.padding(16.dp)) {
            Text(text = "Settings", color = MaterialTheme.colors.primary)
            Spacer(modifier = Modifier.height(16.dp))
            IconWithText(
                icon = Icons.Outlined.NotificationImportant,
                text = "Notification and Sounds"
            )

            IconWithText(
                icon = Icons.Outlined.Lock,
                text = "Notification and Sounds"
            )

            IconWithText(
                icon = Icons.Outlined.PieChart,
                text = "Data and Storage"
            )

            IconWithText(
                icon = Icons.Outlined.ChatBubble,
                text = "Chat settings"
            )

            IconWithText(
                icon = Icons.Outlined.Laptop,
                text = "Devices"
            )
        }
    }
}

@Composable
fun BodyHelp() {
    Card {
        Column(Modifier.padding(16.dp)) {
            Text(text = "Help", color = MaterialTheme.colors.primary)
            Spacer(modifier = Modifier.height(16.dp))
            IconWithText(
                icon = Icons.Outlined.NotificationImportant,
                text = "Notification and Sounds"
            )

            IconWithText(
                icon = Icons.Outlined.Lock,
                text = "Notification and Sounds"
            )

            IconWithText(
                icon = Icons.Outlined.PieChart,
                text = "Data and Storage"
            )
        }
    }
}

@Composable
fun AccountText(text1: String, text2: String) {
    Column {
        Text(text = text1, fontWeight = FontWeight.SemiBold)
        Text(text = text2)
        Spacer(modifier = Modifier.height(4.dp))
        Divider()
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun IconWithText(
    icon: ImageVector,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 9.dp, vertical = 16.dp)
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(text)
    }
}
