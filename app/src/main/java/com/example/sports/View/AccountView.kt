package com.example.sports.View
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.jetbrains.annotations.Async.Schedule

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
    fun AccountView() {
        Text(text = "Account View")
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    //val currentBackStackEntry by navController.currentBackStackEntryAsState()
    //val currentRoute = currentBackStackEntry?.destination?.route
    val scope = rememberCoroutineScope()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            ScheduleStudent()
        }
    }
}

@Composable
fun ScheduleStudent() {
    val daysOfWeek = listOf(
        "Natación", "Box", "Basquetbol", "Futbol Soccer",
        "Futbol Americano", "Gym", "Taekwondo",
        "Teatro", "Danza Folcrórica", "Escolta Institucional"
    )
    val dataDays = listOf("Hora", "Materia")

    // Usar LazyColumn para organizar los días verticalmente y permitir el desplazamiento
    LazyColumn {
        items(daysOfWeek) { day ->
            Text(
                text = day,
                modifier = Modifier.padding(4.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            // Dibuja una línea de separación después de cada día
            HorizontalDivider(
                thickness = 2.dp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(32.dp))

            // Lista de datos estáticos para cada día
            Row(
                modifier = Modifier
                    .padding(2.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                dataDays.forEach { data ->
                    Text(
                        text = data,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }

            // Mostrar el horario correspondiente
            InfoScheduleStudent(day)
        }
    }
}

@Composable
fun InfoScheduleStudent(day: String) {
    val schedules = mapOf(
        "Natación" to listOf(
            "Profesora: Evangelia Juárez Hernandez",
            "Lunes - Viernes 13:00 a 17:00 horas",
            "Sábado 9:00 a 15:00 horas"
        ),
        "Box" to listOf(
            "Profesora: Evangelia Juárez Hernandez",
            "Lunes - Viernes 13:00 a 17:00 horas",
            "Sábado 9:00 a 15:00 horas"
        ),
        "Basquetbol" to listOf(
            "Profesor: Esteban Lacano Hernández",
            "Lunes 15:30 a 20:00 horas",
            "Viernes 16:30 a 20:00 horas",
            "Sábado 7:00 a 14:00 horas"
        ),
        "Futbol Soccer" to listOf(
            "Profesor: Simon Eduardo Guítierrez Benítez",
            "Lunes - viernes 15:00 a 18:00 horas",
            "Martes - miércoles 13:00 a 18:00 horas",
            "Jueves 14:00 a 18:00 horas"
        ),
        "Futbol Americano" to listOf(
            "Profesor: Tadeo Nathan Reyes Espinosa",
            "Lunes - martes 10:00 a 14:00 horas",
            "Miércoles, jueves - viernes 11:00 a 14:00 horas"
        ),
        "Gym" to listOf(
            "Profesor: Ismael Fernández Terrones",
            "Martes - jueves 13:30 a 17:30 horas",
            "Viernes 14:00 a 17:00 horas"
        ),
        "Taekwondo" to listOf(
            "Profesor: Pablo Tlacaélel Rodríguez Figueroa",
            "Lunes, miércoles - viernes 14:00 a 19:00 horas",
            "Martes 9:00 a 11:00 horas"
        ),
        "Teatro" to listOf(
            "Profesor: Sergio Armando Rodríguez",
            "Lunes - martes 15:00 horas"
        ),
        "Danza Folcrórica" to listOf(
            "Profesor: Fernando Barrera Negrete",
            "Lunes, miércoles y viernes 13:00 a 17:00 horas"
        ),
        "Escolta Institucional" to listOf(
            "Lunes 08:00 a 13:00 horas",
            "Martes - jueves 11:00 a 16:00 horas"
        )
    )

    val scheduleList = schedules[day] ?: emptyList()

    // Organizar los horarios verticalmente
    Column(modifier = Modifier.fillMaxWidth()) {
        scheduleList.forEach { schedule ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp)
            ) {
                Text(
                    text = schedule,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

