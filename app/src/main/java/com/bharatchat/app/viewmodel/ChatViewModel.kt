package com.bharatchat.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bharatchat.app.data.ChatRepository
import com.bharatchat.app.data.model.Message
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class ChatUiState(
    val chatId: String,
    val chatTitle: String,
    val messages: List<Message> = emptyList()
)

class ChatViewModel(private val chatId: String) : ViewModel() {
    private val repository = ChatRepository()
    private val _uiState = MutableStateFlow(
        ChatUiState(chatId = chatId, chatTitle = chatId, messages = repository.observeMessages(chatId).value)
    )
    val uiState: StateFlow<ChatUiState> = _uiState

    fun sendMessage(text: String) {
        repository.sendMessage(chatId, text, isMine = true)
        _uiState.value = _uiState.value.copy(
            messages = repository.observeMessages(chatId).value
        )
    }

    companion object {
        fun provideFactory(chatId: String): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return ChatViewModel(chatId) as T
            }
        }
    }
}