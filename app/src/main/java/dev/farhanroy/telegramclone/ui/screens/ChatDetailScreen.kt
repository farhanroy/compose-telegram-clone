package dev.farhanroy.telegramclone.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Attachment
import androidx.compose.material.icons.outlined.EmojiEmotions
import androidx.compose.material.icons.outlined.MicNone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.glide.GlideImage
import dev.farhanroy.telegramclone.Router
import dev.farhanroy.telegramclone.ui.components.PeerBubble
import dev.farhanroy.telegramclone.ui.components.UserBubble
import dev.farhanroy.telegramclone.ui.theme.BottomSheetShapes
import dev.farhanroy.telegramclone.ui.theme.Shapes
import dev.farhanroy.telegramclone.utils.DataDummy
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun ChatDetailScreen(index: Int) {

    val bottomState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
        sheetState = bottomState,
        sheetContent = { ChatDetailBottomSheet() },
        sheetShape = BottomSheetShapes.medium,
        content = {
            Scaffold(
                topBar = { ChatDetailAppBar(index) },
                backgroundColor = Color(0xffC7D9E9),
                bottomBar = { ChatDetailBottomBar(bottomState) },
                content = { ChatDetailBody() }
            )
        }
    )
}

@Composable
private fun ChatDetailAppBar(index: Int ) {

    val chat = DataDummy.listChat[index]
    val router = Router.current

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
            IconButton(onClick = { router.navigateUp() }) {
                Icon(Icons.Default.ArrowBack, contentDescription = null)
            }
        },
        actions = {
            Icon(Icons.Default.MoreVert, contentDescription = null)
        },
    )
}

@Composable
private fun ChatDetailBody() {
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
        item {
            Spacer(modifier = Modifier.height(56.dp))
        }
    }
}

@ExperimentalMaterialApi
@Composable
private fun ChatDetailBottomBar(bottomSheetState: ModalBottomSheetState) {
    val coroutineScope = rememberCoroutineScope()
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
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
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .clickable {
                    coroutineScope.launch { bottomSheetState.show() }
                }
        )
        Icon(
            Icons.Outlined.MicNone,
            tint = Color.LightGray,
            modifier = Modifier.padding(8.dp),
            contentDescription = null
        )
    }
}

@ExperimentalFoundationApi
@Composable
private fun ChatDetailBottomSheet() {
    Column(Modifier.padding(vertical = 16.dp, horizontal = 4.dp)) {

        Box(modifier = Modifier
            .height(4.dp)
            .width(24.dp)
            .align(Alignment.CenterHorizontally)
            .background(color = Color.Gray, shape = RoundedCornerShape(4.dp))
        )
        
        Spacer(modifier = Modifier.height(4.dp))

        LazyVerticalGrid(
            cells = GridCells.Adaptive(minSize = 108.dp),
            modifier = Modifier.height(272.dp),
            content = {
                items(13) {
                    GlideImage(
                        imageModel = "https://randomuser.me/api/portraits/men/12.jpg",
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        )
        Row(
            Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Image,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .background(color = Color.Blue, shape = CircleShape)
                        .padding(10.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "Gallery",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.InsertDriveFile,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .background(color = Color(0xff67B6FF), shape = CircleShape)
                        .padding(10.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "File",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .background(color = Color(0xFF95EF74), shape = CircleShape)
                        .padding(10.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "Location",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Equalizer,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .background(color = Color(0xFFFED671), shape = CircleShape)
                        .padding(10.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "Poll",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .background(color = Color(0xFFFA7781), shape = CircleShape)
                        .padding(10.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "Video",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}