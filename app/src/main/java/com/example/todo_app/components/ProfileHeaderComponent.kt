package com.example.todo_app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo_app.R
import com.example.todo_app.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileHeaderComponent() {
    var darkTheme: Boolean;
    darkTheme = isSystemInDarkTheme();

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.pfp),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(35.dp)
                    .clip(CircleShape)
            )

            BadgedBox(
                badge = {
                    Badge(
                        containerColor = Orange,
                        modifier = Modifier.offset(y = 7.dp, x = (-9).dp)
                    )
                },
            ) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Notifications"
                )
            }
        }

        Divider(

            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            thickness = 2.dp,
            if (darkTheme) Color.White else Color.Black
        )
    }
}