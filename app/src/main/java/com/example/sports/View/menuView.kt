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
                .verticalScroll(rememberScrollState())
        ) {
            Banner(imageRes = R.drawable.nadar) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Natación",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Beneficios de la Natación\n" +
                        "Mejora Cardiovascular: La natación es un ejercicio aeróbico que mejora la salud del corazón y la capacidad pulmonar.\n" +
                        "Fortalecimiento Muscular: Trabaja varios grupos musculares, incluidos los brazos, las piernas, el abdomen y la espalda.\n" +
                        "Flexibilidad y Coordinación: Mejora la flexibilidad y la coordinación, ya que los movimientos requieren un rango completo de movimiento.\n" +
                        "Bajo Impacto: Es una actividad de bajo impacto en las articulaciones, lo que la hace ideal para personas con lesiones o problemas articulares.\n" +
                        "Reducción del Estrés: La inmersión en agua y el ejercicio pueden ayudar a reducir el estrés y mejorar el bienestar mental.",
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
                .verticalScroll(rememberScrollState())
        ) {
            Banner(imageRes = R.drawable.bas) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Baloncesto",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Beneficios del Baloncesto\n" +
                        "Físicos: Mejora la resistencia cardiovascular, fortalece músculos y huesos, y mejora la coordinación.\n" +
                        "Mentales: Fomenta el trabajo en equipo, la disciplina y el pensamiento estratégico.",
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
                title = { Text("Detalles de Futbol") },
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
                .verticalScroll(rememberScrollState())
        ) {
            Banner(imageRes = R.drawable.fut) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Futbol Soccer",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Historia\n" +
                        "Orígenes: El fútbol moderno tiene sus raíces en Inglaterra, donde se formaron las primeras reglas oficiales a mediados del siglo XIX.\n" +
                        "Federación Internacional de Fútbol Asociación (FIFA): Fundada en 1904, es el organismo rector del fútbol mundial. Organiza la Copa Mundial de la FIFA, el torneo más prestigioso del deporte.",
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
                title = { Text("Detalles de Boxeo") },
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
                text = "Boxeo",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Historia del Boxeo\n" +
                        "El boxeo es un deporte de combate en el que dos personas, generalmente usando guantes protectores y otro equipo de seguridad como vendas en las manos y protectores bucales, se enfrentan en una serie de asaltos o rounds. Este deporte tiene una rica historia que se remonta a la antigua Grecia, donde se practicaba como parte de los Juegos Olímpicos. También existen evidencias de prácticas similares en Egipto y Mesopotamia.",
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
                title = { Text("Detalles de Futbol Americano") },
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
                .verticalScroll(rememberScrollState())
        ) {
            Banner(imageRes = R.drawable.amer) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Futbol Americano",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Historia\n" +
                        "Origen: El fútbol americano se desarrolló a partir de los deportes de rugby y fútbol (soccer) en el siglo XIX en los Estados Unidos.\n" +
                        "Primer juego: El primer juego intercolegial se jugó el 6 de noviembre de 1869 entre Rutgers y Princeton.\n" +
                        "Evolución: Walter Camp, conocido como el \"Padre del Fútbol Americano\", introdujo varias reglas importantes que diferenciaron al fútbol americano del rugby, incluyendo la línea de scrimmage, el sistema de downs, y el concepto de equipo ofensivo y defensivo.",
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
                title = { Text("Detalles de Gimnasio") },
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
                .verticalScroll(rememberScrollState())
        ) {
            Banner(imageRes = R.drawable.gymp) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Gimnasio",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Información sobre Gimnasio y Pesas\n" +
                        "Beneficios del Entrenamiento en el Gimnasio\n" +
                        "Mejora de la Salud Física:\n" +
                        "\n" +
                        "Fortalecimiento Muscular: Levantar pesas y realizar ejercicios de resistencia aumenta la masa muscular y la fuerza.\n" +
                        "Salud Cardiovascular: El ejercicio regular mejora la eficiencia del corazón y la circulación sanguínea.\n" +
                        "Control de Peso: Ayuda a quemar calorías y a mantener un peso saludable.\n" +
                        "Beneficios Mentales y Emocionales:\n" +
                        "\n" +
                        "Reducción del Estrés: El ejercicio libera endorfinas, que son hormonas que mejoran el estado de ánimo y reducen el estrés.\n" +
                        "Mejora del Sueño: La actividad física regular puede ayudar a mejorar la calidad del sueño.\n" +
                        "Aumento de la Confianza: Ver mejoras en el rendimiento y la apariencia física puede aumentar la autoestima y la confianza.",
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
                title = { Text("Detalles de Tae Kwon Do") },
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
                .verticalScroll(rememberScrollState())
        ) {
            Banner(imageRes = R.drawable.taedo) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Tae Kwon Do",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Historia y Origen\n" +
                        "Origen: El Taekwondo se originó en Corea durante la década de 1940 y 1950, cuando varios artistas marciales coreanos combinaron sus conocimientos de artes marciales nativas coreanas (como el Taekkyeon) y el Karate japonés.\n" +
                        "Fundador: Generalmente se atribuye su formalización al General Choi Hong Hi, quien estableció los principios y el nombre del Taekwondo en 1955.",
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
                title = { Text("Detalles de Voleibol") },
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
                .verticalScroll(rememberScrollState())
        ) {
            Banner(imageRes = R.drawable.vole) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Voleiboy",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Historia y Orígenes\n" +
                        "El voleibol fue inventado en 1895 por William G. Morgan, un instructor de educación física en Holyoke, Massachusetts, Estados Unidos. Morgan creó el juego como una alternativa menos intensa que el baloncesto para los hombres de negocios mayores que querían un ejercicio físico sin un contacto físico excesivo. Originalmente se llamó \"Mintonette\", pero el nombre fue cambiado a voleibol después de que un observador notara que el juego involucraba muchas voleas.",
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
                title = { Text("Detalles de Escolta") },
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
                .verticalScroll(rememberScrollState())
        ) {
            Banner(imageRes = R.drawable.escoltaa) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Escolta",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Funciones y Responsabilidades\n" +
                        "Participación en Ceremonias: La escolta es responsable de portar y resguardar la bandera en actos cívicos, desfiles, y eventos escolares.\n" +
                        "Representación: Representan a la escuela en eventos externos, como desfiles patrios, competencias interescolares, y otros actos oficiales.\n" +
                        "Disciplina y Comportamiento: Los miembros de la escolta deben mantener una conducta ejemplar, tanto dentro como fuera de la institución.\n" +
                        "Entrenamiento: Reciben entrenamiento en disciplina, marcha, y manejo adecuado de la bandera.",
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
                title = { Text("Detalles de Danza") },
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
                .verticalScroll(rememberScrollState())
        ) {
            Banner(imageRes = R.drawable.danzaf) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Danza Folclórica",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Historia y Origen:\n" +
                        "Orígenes: Las danzas folclóricas suelen tener raíces en las comunidades rurales y agrarias, y se transmiten de generación en generación.\n" +
                        "Evolución: Con el tiempo, estas danzas han evolucionado y se han adaptado, aunque muchas han mantenido sus elementos tradicionales.",
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
                title = { Text("Detalles de Atletismo") },
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
                .verticalScroll(rememberScrollState())
        ) {
            Banner(imageRes = R.drawable.atle) // Replace with your banner image resource
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Atletismo",
                fontSize = 24.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Carreras:\n" +
                        "\n" +
                        "Velocidad: Carreras de corta distancia que requieren rapidez y explosividad, como los 100, 200 y 400 metros.\n" +
                        "Medio Fondo: Carreras que combinan velocidad y resistencia, como los 800 y 1500 metros.\n" +
                        "Fondo: Carreras de larga distancia que requieren una gran resistencia, como los 5000 y 10000 metros.\n" +
                        "Vallas: Carreras que incluyen obstáculos, como los 110 metros vallas (hombres), 100 metros vallas (mujeres) y 400 metros vallas.\n" +
                        "Relevos: Carreras en equipo donde los atletas se pasan un testigo, como los 4x100 y 4x400 metros.",
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

