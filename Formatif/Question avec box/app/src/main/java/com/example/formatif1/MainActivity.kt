package com.example.formatif1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                    Greeting()
            }
        }
    }
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    Scaffold(
        topBar = {
            // On utilise une Column pour empiler la TopAppBar puis un Divider en dessous
            Column {
                TopAppBar(

                    title = { Text("MiSE EN PAGE",
                        fontSize = 22.sp,               //  Taille du texte
                        fontWeight = FontWeight.Bold,   // Gras
                        modifier = Modifier.fillMaxWidth(), // ↔ Prend toute la largeur
                        textAlign = TextAlign.Center ,   //  Centre le texte
                        color = Color.Black, // Couleur du texte
                    )
                    }
                )

                // Ligne (divider) sous la TopAppBar
                HorizontalDivider(color = Color.LightGray, thickness = 4.dp)
            }
         },
     ) { innerPadding ->
         //Contenu principal de l’écran
        Column(// lorsque je met des éléments dans le modifier, il s'applique à tous les éléments de la colonne.
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()

        ) {
            // Bouton prenant toute la largeur
            Button(// si je veux modifier un seul élément, je dois mettre le modifier directement dans le bouton.
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(0.dp) // modifier la shape du bouton
            ) {
                Text(text = "EXAMEN")
            } //Bouton clickable mais qui n'amène nul part.






            Spacer(modifier = Modifier.height(16.dp))

            // Grille 2x2 de boxes (prend tout l'espace restant sous le bouton)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f) // occupe l'espace restant verticalement
            ) {




                // 1ère rangée (prend la moitié de la hauteur restante)
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f) // prend moitié largeur
                            .fillMaxHeight() // remplit la hauteur de la rangée
                            .border(1.dp, Color.Gray, RoundedCornerShape(0.dp)),

                    ) {

                    }
                    Box(
                        modifier = Modifier
                            .weight(1f) // prend moitié largeur
                            .fillMaxHeight() // remplit la hauteur de la rangée
                            .background(Color.Black)
                            .border(1.dp, Color.Gray, RoundedCornerShape(0.dp)),

                    ) {

                    }
                }





                // 2ème rangée (prend l'autre moitié)
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .background(Color.Blue)
                            .border(1.dp, Color.Gray, RoundedCornerShape(0.dp)),

                    ) {

                    }
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .border(1.dp, Color.Gray, RoundedCornerShape(0.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            onClick = {},
                            modifier = Modifier.align(Alignment.Center)
                        ) {
                            Text(text = "Bouton")
                        }
                     }
                }
            }
        }
     }
 }
