package com.example.sports.View

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

data class SectionData(val title: String, val content: String)

@Composable
fun AboutView() {
    val sections = listOf(
        SectionData(
            title = "Misión",
            content = "Promover y transmitir al educando información deportiva, cultural y recreativa, desarrollando sus habilidades cognitivas y fomentando un aprendizaje permanente e integral a lo largo de la vida. Nuestro objetivo es organizar y optimizar el uso del tiempo libre de los estudiantes, garantizando su derecho a la cultura física y la práctica del deporte, con un enfoque en la integración de equipos representativos."
        ),
        SectionData(
            title = "Valores",
            content = """
                Compromiso: Nos dedicamos a ofrecer programas y actividades que enriquezcan la vida de nuestros estudiantes, fomentando una cultura de responsabilidad y dedicación.
                Inclusión: Promovemos la participación de todos los estudiantes, sin importar sus habilidades o antecedentes, en actividades deportivas y culturales.
                Excelencia: Nos esforzamos por alcanzar altos estándares en todos nuestros programas y servicios, incentivando a los estudiantes a dar lo mejor de sí mismos.
                Colaboración: Fomentamos el trabajo en equipo y la cooperación entre estudiantes, profesores y la comunidad universitaria.
                Desarrollo Integral: Creemos en el crecimiento holístico del individuo, promoviendo tanto el bienestar físico como el desarrollo cultural y cognitivo.
                Innovación: Buscamos constantemente nuevas formas de mejorar nuestras actividades y programas, incorporando tecnologías y metodologías avanzadas.
            """.trimIndent()
        ),
        SectionData(
            title = "¿Quiénes Somos?",
            content = "Somos una entidad comprometida con el desarrollo integral de los estudiantes universitarios, enfocándonos en la promoción de actividades culturales y deportivas. Nuestro equipo está compuesto por profesionales dedicados a crear un entorno donde los estudiantes puedan explorar sus intereses, desarrollar nuevas habilidades y disfrutar de su tiempo libre de manera productiva."
        ),
        SectionData(
            title = "Sobre Nosotros",
            content = "Nos especializamos en ofrecer una amplia gama de actividades y programas diseñados para fomentar el bienestar físico y el enriquecimiento cultural de la población universitaria. A través de la organización de eventos deportivos, talleres culturales y recreativos, y la formación de equipos representativos, buscamos garantizar que todos los estudiantes tengan acceso a oportunidades que promuevan su desarrollo personal y académico. Nuestro compromiso es crear un ambiente inclusivo y de apoyo, donde cada estudiante pueda alcanzar su máximo potencial."
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(sections) { section ->
            Section(title = section.title) {
                Text(
                    text = section.content,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun Section(title: String, content: @Composable () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.2f),
        shadowElevation = 8.dp  // Agregar sombra a las cajas
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold, fontSize = MaterialTheme.typography.titleLarge.fontSize * 1.2),
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            content()
        }
    }
}
