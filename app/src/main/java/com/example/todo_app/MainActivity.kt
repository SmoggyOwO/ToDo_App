package com.example.todo_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo_app.components.ProfileHeaderComponent
import com.example.todo_app.components.TaskComponent
import com.example.todo_app.components.WelcomeMessageComponent
import com.example.todo_app.data.taskList
import com.example.todo_app.ui.theme.TaskManagerAppJetpackComposeTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var selectedScreen by remember { mutableStateOf(1) }
            val screens = listOf("Calender", "Home", "Notifications")
            TaskManagerAppJetpackComposeTheme {
                Scaffold (
                    bottomBar = {
                        NavigationBar (
                            modifier = Modifier.height(60.dp),
                            containerColor = Color.White,
                            tonalElevation = 0.dp,
                                )
                        {
                            screens.forEachIndexed {
                                index, _ ->
                                val icon: ImageVector = when (index) {
                                    0 -> Icons.Filled.DateRange
                                    1 -> Icons.Filled.Home
                                    2 -> Icons.Filled.Notifications
                                    else -> Icons.Filled.Home
                                }
                                 NavigationBarItem(
                                    selected = selectedScreen == index,
                                    onClick = { selectedScreen = index },
                                    icon = {
                                        Box(
                                            modifier = Modifier
                                                .size(55.dp)
                                                .clip(CircleShape)
                                                .background(
                                                    if (selectedScreen == index) {
                                                        Color.Black
                                                    }
                                                else {
                                                    Color.White
                                                    }
                                                ),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(
                                                imageVector = icon,
                                                contentDescription = "Screen",
                                                modifier = Modifier
                                                    .size(55.dp)
                                                    .padding(12.dp),
                                                tint = if (selectedScreen == index) { Color.White } else { Color.Black }
                                            )
                                        }
                                    },
                                )
                            }
                        }
                    }
                        ) {
                    LazyColumn(
                        contentPadding = PaddingValues(
                            start = 16.dp,
                            top = 16.dp,
                            bottom = 16.dp,
                        )
                    ) {
                        item {
                            ProfileHeaderComponent()
                        }
                        item {
                            WelcomeMessageComponent()
                        }
                        items(taskList) {
                                task -> TaskComponent(task = task)
                        }
                    }
                }

            }
        }
    }
}

