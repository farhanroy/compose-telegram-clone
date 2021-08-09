package dev.farhanroy.telegramclone.utils

data class Chat(
    val id: Int,
    val name: String,
    val time: String,
    val date: String?,
    val lastMessage: String?,
    val imageUrl: String
)

data class Message(
    val message: String,
    val isPeer: Boolean
)

object DataDummy {
    val listChat = listOf(
        Chat(
            id = 0,
            name = "Farhan Roy",
            time = "08:46",
            date = "17 june",
            lastMessage = "Assalamualaikum",
            imageUrl = "https://randomuser.me/api/portraits/men/12.jpg"
        ),
    )

    val listMessage = listOf(
        Message("Hi Roy how are you ?", false),
        Message("Iam fine, how are you ?", true),
        Message("Iam fine too", false),
        Message("What do you do now ?", true),
        Message("Write a book, and doing my work", false),
        Message("Wow, its so good man", true),
        Message("Yeah", false),
    )
}