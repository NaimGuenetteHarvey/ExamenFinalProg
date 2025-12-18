package com.example.liste20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListeVersionsAndroid()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListeVersionsAndroid() {
    val versions = listOf(
        "Android 1.1" to "Petit Four",
        "Android 1.5" to "Cupcake",
        "Android 2.0" to "Éclair",
        "Android 3.0" to "Honeycomb",
        "Android 4.0" to "Ice Cream Sandwich",
        "Android 5.0" to "Lollipop"
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Versions") })
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(versions) { (version, nom) ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                        .padding(12.dp)
                ) {
                    // Ligne 1 : version Android (gauche)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = version,
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 8.dp),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Start
                        )

                        // Remplisseur pour occuper la partie droite
                        Spacer(modifier = Modifier.weight(3f))
                    }

                    // Ligne 2 : nom du dessert (décalé vers la droite)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Remplisseur pour laisser la partie gauche vide
                        Spacer(modifier = Modifier.weight(3f))

                        Text(
                            text = nom,
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 8.dp),
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                            color = Color(0xFF5C4DB1)
                        )
                    }
                }
            }
        }
    }
}