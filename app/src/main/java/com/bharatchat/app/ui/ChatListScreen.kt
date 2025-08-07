package com.bharatchat.app.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bharatchat.app.viewmodel.ChatListUiState

@Composable
fun ChatListScreen(
    uiState: ChatListUiState,
    onChatClicked: (String) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "BharatChat") })
        }
    ) { padding ->
        if (uiState.chats.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No chats yet")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                items(uiState.chats) { chat ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onChatClicked(chat.id) }
                            .padding(16.dp)
                    ) {
                        Text(text = chat.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = chat.lastMessagePreview, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                    Divider()
                }
            }
        }
    }
}