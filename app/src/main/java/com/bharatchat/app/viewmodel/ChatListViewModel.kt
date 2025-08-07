package com.bharatchat.app.viewmodel

import androidx.lifecycle.ViewModel
import com.bharatchat.app.data.ChatRepository
import com.bharatchat.app.data.model.Chat
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class ChatListUiState(
    val chats: List<Chat> = emptyList()
)

class ChatListViewModel : ViewModel() {
    private val repository = ChatRepository()
    private val _uiState = MutableStateFlow(ChatListUiState())
    val uiState: StateFlow<ChatListUiState> = _uiState

    init {
        // Mirror repository data
        _uiState.value = ChatListUiState(chats = repository.observeChats().value)
    }
}