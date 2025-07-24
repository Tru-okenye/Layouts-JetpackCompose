package com.example.ui_layouts.ui.theme


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui_layouts.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutScreen() {
    val activities = listOf("Logged in", "Updated profile", "Logged out")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile App") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Add action */ }) {
                Text("+")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Profile section
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.profile), // add profile.jpg to res/drawable
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text("John Doe", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text("john@example.com", color = Color.Gray)
                }
            }

            // Row of buttons
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = {}) {
                    Text("Edit")
                }
                Button(onClick = {}) {
                    Text("Settings")
                }
            }

            // Activity list
            Text("Recent Activities", fontWeight = FontWeight.Bold)
            LazyColumn {
                items(activities.size) { index ->
                    Text("• ${activities[index]}", modifier = Modifier.padding(vertical = 4.dp))
                }
            }
        }
    }
}
