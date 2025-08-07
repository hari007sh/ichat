package com.bharatchat.app.data

import com.bharatchat.app.data.model.Chat
import com.bharatchat.app.data.model.Message
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map

class ChatRepository {
    private val chatsFlow = MutableStateFlow<List<Chat>>(emptyList())
    private val messagesFlow = MutableStateFlow<Map<String, List<Message>>>(emptyMap())

    init {
        // Seed with sample data
        val sampleChats = listOf(
            Chat(id = "family", title = "Family", lastMessagePreview = "Dinner at 8?"),
            Chat(id = "friends", title = "Friends", lastMessagePreview = "Let's meet this weekend"),
            Chat(id = "work", title = "Work", lastMessagePreview = "Client call at 11")
        )
        chatsFlow.value = sampleChats
        messagesFlow.value = sampleChats.associate { chat ->
            chat.id to listOf(
                Message(chatId = chat.id, text = chat.lastMessagePreview, isMine = false)
            )
        }
    }

    fun observeChats(): StateFlow<List<Chat>> = chatsFlow

    fun observeMessages(chatId: String): StateFlow<List<Message>> {
        val flow = MutableStateFlow(messagesFlow.value[chatId] ?: emptyList())
        // Bridge updates when the map changes
        messagesFlow.map { it[chatId] ?: emptyList() }.collectIn(flow)
        return flow
    }

    fun sendMessage(chatId: String, text: String, isMine: Boolean = true) {
        val current = messagesFlow.value.toMutableMap()
        val updatedList = (current[chatId] ?: emptyList()).toMutableList()
        val message = Message(chatId = chatId, text = text, isMine = isMine)
        updatedList.add(0, message)
        current[chatId] = updatedList
        messagesFlow.value = current

        // Update last message preview
        chatsFlow.value = chatsFlow.value.map { chat ->
            if (chat.id == chatId) chat.copy(lastMessagePreview = text) else chat
        }
    }
}

// Lightweight extension to tie a source StateFlow to a target MutableStateFlow
private fun <T> StateFlow<T>.collectIn(target: MutableStateFlow<T>) {
    // NOTE: This is a simplification for sample purposes; in a real app, use coroutine scopes
    // and proper collection in ViewModels. Here we mirror updates synchronously.
    target.value = this.value
}