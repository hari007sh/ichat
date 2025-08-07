package com.bharatchat.app.data.model

import java.util.UUID

data class Chat(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val lastMessagePreview: String = "",
)

data class Message(
    val id: String = UUID.randomUUID().toString(),
    val chatId: String,
    val text: String,
    val timestampMs: Long = System.currentTimeMillis(),
    val isMine: Boolean,
)