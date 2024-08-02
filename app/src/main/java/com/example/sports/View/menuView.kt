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
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sports.Components.MenuLateral
import com.example.sports.R
import com.example.sports.ViewModel.MenuViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuView(navController: NavController, ViewModel: MenuViewModel) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var showDialog by remember { mutableStateOf(false) }

    MenuLateral(navController = navController, drawerState = drawerState) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch { drawerState.open() }
                        }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            showDialog = true
                        }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                                contentDescription = "Logout"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = { showDialog = false },
                        title = { Text("Salir de UTRegistro") },
                        text = { Text("¿Estás seguro de que quieres salir de la aplicación?") },
                        confirmButton = {
                            TextButton(onClick = {
                                ViewModel.salirApp()
                                showDialog = false
                            }) {
                                Text("Sí")
                            }
                        },
                        dismissButton = {
                            TextButton(onClick = { showDialog = false }) {
                                Text("No")
                            }
                        }
                    )
                }
            }
        ) { paddingValues ->
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(scrollState)
            ) {
                MenuCard(
                    title = "Natación",
                    description = "Resistencia, técnicas de estilos (crol, espalda, pecho, mariposa).",
                    imageRes = R.drawable.natacion,
                    onClick = { navController.navigate("detail_view/natacion") }
                )
                Spacer(modifier = Modifier.height(16.dp))

                MenuCard(
                    title = "Baloncesto",
                    description = "Encestar, driblar, pases, rebotes.",
                    imageRes = R.drawable.basquetbol,
                    onClick = { navController.navigate("detail_view/baloncesto") }
                )
                Spacer(modifier = Modifier.height(16.dp))

                MenuCard(
                    title = "Fútbol Soccer",
                    description = "Técnica de balón, tácticas, goles.",
                    imageRes = R.drawable.futbol,
                    onClick = { navController.navigate("detail_view/futbol") }
                )
                Spacer(modifier = Modifier.height(16.dp))

                MenuCard(
                    title = "Boxeo",
                    description = "Golpes, defensa, combinaciones.",
                    imageRes = R.drawable.box,
                    onClick = { navController.navigate("detail_view/boxeo") }
                )
                Spacer(modifier = Modifier.height(16.dp))

                MenuCard(
                    title = "Fútbol Americano",
                    description = "Estrategia, tácticas de ataque/defensa, pases, bloqueos.",
                    imageRes = R.drawable.amer,
                    onClick = { navController.navigate("detail_view/futbol_americano") }
                )
                Spacer(modifier = Modifier.height(16.dp))

                MenuCard(
                    title = "Gimnasio y Pesas",
                    description = "Fuerza, entrenamiento muscular, ejercicios de levantamiento.",
                    imageRes = R.drawable.gym,
                    onClick = { navController.navigate("detail_view/gimnasio") }
                )
                Spacer(modifier = Modifier.height(16.dp))

                MenuCard(
                    title = "Taekwondo",
                    description = "Patadas, técnicas de combate, disciplina.",
                    imageRes = R.drawable.tae,
                    onClick = { navController.navigate("detail_view/taekwondo") }
                )
                Spacer(modifier = Modifier.height(16.dp))

                MenuCard(
                    title = "Voleibol",
                    description = "Red, saques, bloqueos, recepción.",
                    imageRes = R.drawable.volei,
                    onClick = { navController.navigate("detail_view/voleibol") }
                )
                Spacer(modifier = Modifier.height(16.dp))

                MenuCard(
                    title = "Escolta",
                    description = "Defensa personal, técnicas de protección.",
                    imageRes = R.drawable.escolta,
                    onClick = { navController.navigate("detail_view/escolta") }
                )
                Spacer(modifier = Modifier.height(16.dp))

                MenuCard(
                    title = "Danza Folclórica",
                    description = "Cultura, tradiciones, pasos coreográficos.",
                    imageRes = R.drawable.danza,
                    onClick = { navController.navigate("detail_view/danza") }
                )
                Spacer(modifier = Modifier.height(16.dp))

                MenuCard(
                    title = "Atletismo",
                    description = "Carreras, saltos, lanzamientos, resistencia.",
                    imageRes = R.drawable.atletismo,
                    onClick = { navController.navigate("detail_view/atletismo") }
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
fun DetailViewNatacion(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalles de Natación") },
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
            Banner(imageRes = R.drawable.nadar) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Natación",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Resistencia, técnicas de estilos (crol, espalda, pecho, mariposa).",
                fontSize = 16.sp
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailViewBaloncesto(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalles de Baloncesto") },
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
            Banner(imageRes = R.drawable.bas) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Baloncesto",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Encestar, driblar, pases, rebotes.",
                fontSize = 16.sp
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailViewFutbol(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalles de Baloncesto") },
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
            Banner(imageRes = R.drawable.fut) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Baloncesto",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Encestar, driblar, pases, rebotes.",
                fontSize = 16.sp
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailViewBoxeo(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalles de Baloncesto") },
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
            Banner(imageRes = R.drawable.boxing) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Baloncesto",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Encestar, driblar, pases, rebotes.",
                fontSize = 16.sp
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailViewFutbolAmericano(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalles de Baloncesto") },
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
            Banner(imageRes = R.drawable.amer) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Baloncesto",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Encestar, driblar, pases, rebotes.",
                fontSize = 16.sp
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailViewGimnasio(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalles de Baloncesto") },
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
            Banner(imageRes = R.drawable.gymp) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Baloncesto",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Encestar, driblar, pases, rebotes.",
                fontSize = 16.sp
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailViewTaekwondo(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalles de Baloncesto") },
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
            Banner(imageRes = R.drawable.taedo) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Baloncesto",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Encestar, driblar, pases, rebotes.",
                fontSize = 16.sp
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailViewVoleibol(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalles de Baloncesto") },
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
            Banner(imageRes = R.drawable.vole) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Baloncesto",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Encestar, driblar, pases, rebotes.",
                fontSize = 16.sp
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailViewEscolta(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalles de Baloncesto") },
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
            Banner(imageRes = R.drawable.escoltaa) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Baloncesto",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Encestar, driblar, pases, rebotes.",
                fontSize = 16.sp
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailViewDanza(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalles de Baloncesto") },
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
            Banner(imageRes = R.drawable.danzaf) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Baloncesto",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Encestar, driblar, pases, rebotes.",
                fontSize = 16.sp
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailViewAtletismo(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalles de Baloncesto") },
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
                text = "Baloncesto",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Encestar, driblar, pases, rebotes.",
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

