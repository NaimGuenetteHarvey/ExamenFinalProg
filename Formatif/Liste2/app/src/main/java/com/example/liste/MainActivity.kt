package com.example.liste

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.liste.ui.theme.ListeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListeTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "list",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("list") {
                            ListeScreen(onItemClick = { name ->
                                // navigation vers l'écran détail (encode le nom pour les caractères spéciaux)
                                navController.navigate("detail/${Uri.encode(name)}")
                            })
                        }

                        composable(
                            route = "detail/{name}",
                            arguments = listOf(navArgument("name") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val name = backStackEntry.arguments?.getString("name") ?: ""
                            DetailScreen(name = name, onBack = { navController.popBackStack() })
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ListeScreen(onItemClick: (String) -> Unit) {
    // Liste de prénoms A -> L
    val names = listOf(
        "Alice",
        "Bruno",
        "Chloé",
        "David",
        "Emma",
        "Félix",
        "Giselle",
        "Hugo",
        "Isabelle",
        "Julien",
        "Karim",
        "Léa"
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Titre en haut à gauche avec Divider
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Liste", fontWeight = FontWeight.Bold)
            }
            HorizontalDivider(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
        }

        LazyColumn {
            items(names) { name ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Bouton placé à gauche
                    Button(onClick = { onItemClick(name) }) {
                        Text(text = "X")
                    }

                    Text(text = name)
                }
                HorizontalDivider()
            }
        }
    }
}

@Composable
fun DetailScreen(name: String, onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Détail de: $name", fontWeight = FontWeight.Bold)
        // Bouton de retour (simple)
        Button(onClick = onBack, modifier = Modifier.padding(top = 16.dp)) {
            Text(text = "Retour")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListePreview() {
    ListeTheme {
        ListeScreen(onItemClick = {})
    }
}