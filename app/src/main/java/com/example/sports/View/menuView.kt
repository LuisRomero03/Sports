package com.example.sports.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sports.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Menu") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(scrollState)
        ) {
            for (i in 1..1) {
                MenuCard(
                    title = "Natación $i",
                    description = "Natación: Nadar en el agua para mejorar la resistencia y la flexibilidad. $i.",
                    imageRes = R.drawable.nadar, // Replace with your image resource
                    onClick = { navController.navigate("detail_view/$i") }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            for (i in 1..1) {
                MenuCard(
                    title = "Basquetbol",
                    description = "Baloncesto: Anotar puntos encestando un balón en el aro rival. $i.",
                    imageRes = R.drawable.bas, // Replace with your image resource
                    onClick = { navController.navigate("detail_view/$i") }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            for (i in 1..1) {
                MenuCard(
                    title = "Futbol Soccer",
                    description = "Fútbol Soccer: Marcar goles con el balón en la portería contraria. $i.",
                    imageRes = R.drawable.futbol, // Replace with your image resource
                    onClick = { navController.navigate("detail_view/$i") }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            for (i in 1..1) {
                MenuCard(
                    title = "Box",
                    description = "Boxeo: Deporte de combate enfocado en la fuerza y la estrategia. $i.",
                    imageRes = R.drawable.box, // Replace with your image resource
                    onClick = { navController.navigate("detail_view/$i") }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }

            for (i in 1..1) {
                MenuCard(
                    title = "Futbol Americano",
                    description = "Fútbol Americano: Avanzar un balón hacia la zona de anotación rival, combinando fuerza y táctica. $i.",
                    imageRes = R.drawable.amer, // Replace with your image resource
                    onClick = { navController.navigate("detail_view/$i") }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            for (i in 1..1) {
                MenuCard(
                    title = "Gimnasio y Pesas",
                    description = "Gimnasio y Pesas: Fortalecer músculos y mejorar la condición física. $i.",
                    imageRes = R.drawable.gymp, // Replace with your image resource
                    onClick = { navController.navigate("detail_view/$i") }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            for (i in 1..1) {
                MenuCard(
                    title = "Taekwondo",
                    description = "Taekwondo: Arte marcial que usa la flexibilidad y disciplina. $i.",
                    imageRes = R.drawable.taedo, // Replace with your image resource
                    onClick = { navController.navigate("detail_view/$i") }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            for (i in 1..1) {
                MenuCard(
                    title = "Voleibol",
                    description = "Voleibol: Diciplina que fortelece la estrategia$i.",
                    imageRes = R.drawable.volei, // Replace with your image resource
                    onClick = { navController.navigate("detail_view/$i") }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            for (i in 1..1) {
                MenuCard(
                    title = "Escolta",
                    description = "Escolta: Técnica y coordinacion mejorada. $i.",
                    imageRes = R.drawable.esco, // Replace with your image resource
                    onClick = { navController.navigate("detail_view/$i") }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            for (i in 1..1) {
                MenuCard(
                    title = "Danza Folclórica",
                    description = "Danza Folclórica: Danzas tradicionales que reflejan la cultura regional. $i.",
                    imageRes = R.drawable.danzaf, // Replace with your image resource
                    onClick = { navController.navigate("detail_view/$i") }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            for (i in 1..1) {
                MenuCard(
                    title = "Atletismo",
                    description = "Atletismo: Eventos deportivos enfocados en velocidad, fuerza y resistencia.$i.",
                    imageRes = R.drawable.atle, // Replace with your image resource
                    onClick = { navController.navigate("detail_view/$i") }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}


@Composable
fun MenuCard(title: String, description: String, imageRes: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(104.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = description,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView(navController: NavController, itemId: Int) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail View") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Banner(imageRes = R.drawable.atle) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Detail View for Item $itemId",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Here is more detailed information about item $itemId.",
                fontSize = 16.sp
            )

        }
    }
}
@Composable
fun Banner(imageRes: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .align(Alignment.BottomCenter)
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.5f))
        ) {
            Text(
                text = "Banner Text",
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
//informacion de cada diciplina