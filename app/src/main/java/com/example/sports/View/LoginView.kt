package com.example.sports.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sports.ui.theme.gradient1
import com.example.sports.ui.theme.gradient2
import com.example.sports.ui.theme.md_theme_light_primary
import com.example.sports.ui.theme.md_theme_light_secondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(modifier: Modifier = Modifier){

    Column(modifier = Modifier.padding(60.dp, 20.dp)) {
        Image(
            painterResource(com.example.sports.R.drawable.image),
            contentDescription = null,
            Modifier
                .size(180.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(text = "Iniciar Sesión",
            modifier = modifier,
            style = MaterialTheme.typography.bodyMedium)
        Text(text = "Porfavor inicia sesion para continuar.",
            color = md_theme_light_primary,
            fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.height(50.dp))


        InputTextField(label = "Matricula")
        InputTextField(label = "Contraseña")


        GradientButton(
            text = "Iniciar", textColor = Color.White,
            gradient = Brush.horizontalGradient(colors = listOf(gradient1, gradient2))
        ){}

    }
}


@Composable
fun InputTextField(label: String) {
    OutlinedTextField(value = "", onValueChange = {},
        label = { Text(text = label,
            style = TextStyle(color = md_theme_light_primary,)
        ) },
        /*colors = TextFieldDefaults.outlinedTextFieldColors
            (unfocusedBorderColor = Gray),*/
        placeholder = {Text(
            stringResource(com.example.sports.R.string.placeholder2),
            style = TextStyle(color = md_theme_light_secondary)
        )}
    )

}


@Composable
fun GradientButton(
    text: String,
    textColor:Color,
    gradient: Brush,
    onClick: ()->Unit,
){
    Spacer(modifier = Modifier.height(20.dp))
    Button(onClick = { onClick() },
//        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(50.dp)
    ) {

        Box(modifier = Modifier
            .background(gradient)
            .padding(20.dp, 12.dp)
        ){

            Text(text = text, color = textColor)
        }
    }

    Row() {
        Text(
            text = "¿Ya tienes cuenta?",
            color = md_theme_light_primary,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(top = 50.dp)
        )
//          ClickableText(text = AnnotatedString("LogIn"), onClick = {},
////              color = MaterialTheme.colors.primary,
////              fontWeight = FontWeight.SemiBold,
//              modifier = Modifier
//                  .padding(top = 50.dp))
        Text(
            text = "Iniciar Sesión",
            color = md_theme_light_primary,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 50.dp)
                .padding(horizontal = 10.dp)
        )
    }
}

