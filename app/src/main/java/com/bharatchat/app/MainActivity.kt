package com.bharatchat.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bharatchat.app.ui.ChatListScreen
import com.bharatchat.app.ui.ChatScreen
import com.bharatchat.app.ui.theme.BharatChatTheme
import com.bharatchat.app.viewmodel.ChatListViewModel
import com.bharatchat.app.viewmodel.ChatViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BharatChatTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    BharatChatApp()
                }
            }
        }
    }
}

@Composable
fun BharatChatApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "chat_list") {
        composable("chat_list") {
            val vm: ChatListViewModel = viewModel()
            val state by vm.uiState.collectAsState()

            ChatListScreen(
                uiState = state,
                onChatClicked = { chatId ->
                    navController.navigate("chat/$chatId")
                }
            )
        }
        composable(
            route = "chat/{chatId}",
            arguments = listOf(navArgument("chatId") { type = NavType.StringType })
        ) { backStackEntry ->
            val chatId = backStackEntry.arguments?.getString("chatId").orEmpty()
            val vm: ChatViewModel = viewModel(factory = ChatViewModel.provideFactory(chatId))
            val state by vm.uiState.collectAsState()

            ChatScreen(
                uiState = state,
                onSend = { text -> vm.sendMessage(text) },
                onBack = { navController.popBackStack() }
            )
        }
    }
}