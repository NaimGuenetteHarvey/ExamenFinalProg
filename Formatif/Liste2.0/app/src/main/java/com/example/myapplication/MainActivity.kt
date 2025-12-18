package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidVersionsListSimple()
        }
    }
}

@Composable
fun AndroidVersionsListSimple() {
    val versions = listOf(
        "Android 1.1" to "Petit Four",
        "Android 1.5" to "Cupcake",
        "Android 2.0" to "Éclair",
        "Android 3.0" to "Honeycomb",
        "Android 4.0" to "Ice Cream Sandwich",
        "Android 5.0" to "Lollipop"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text("VERSIONS", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
        }

        items(versions) { (version, nom) ->
            Column(modifier = Modifier.padding(vertical = 6.dp)) {
                Text(text = version, style = MaterialTheme.typography.bodyLarge)
                Text(
                    text = "> $nom",
                    modifier = Modifier.padding(start = 20.dp), // décalage à droite
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}