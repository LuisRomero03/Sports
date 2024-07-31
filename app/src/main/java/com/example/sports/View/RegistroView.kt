package com.example.sports.View

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sports.R
import com.example.sports.ui.theme.gradient1
import com.example.sports.ui.theme.gradient2
import com.example.sports.ui.theme.md_theme_light_primary
import com.example.sports.ui.theme.md_theme_light_secondary

@Composable
fun RegistroView(modifier: Modifier = Modifier){

    Column() {

        Row() {
            val columnPaddingY = 20.dp
            val columnPaddingX = 10.dp
            Image(
                painterResource(R.drawable.image2),
                contentDescription = null,
                Modifier
                    .size(210.dp)
//                    .align(Alignment.End)
            )
            Image(
                painterResource(R.drawable.image1),
                contentDescription = null,
                Modifier
                    .size(180.dp)
//                    .align(Alignment.End)
                    .offset(y = -columnPaddingY)
                    .offset(x = columnPaddingX)
            )
        }


        Column(modifier = Modifier.padding(60.dp, 10.dp)) {
            Text(
                text = "Crear cuenta",
                modifier = modifier.padding(top = 0.dp),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 35.sp
            )

            Spacer(modifier = Modifier.height(30.dp))


            InputTextField(label = "Nombre completo")
            InputTextField(label = "Matricula")
            InputTextField(label = "Contraseña")
            InputTextField(label = "Confirmar contraseña")




            GradientButtoon(
                text = "Continue", textColor = Color.White,
                gradient = Brush.horizontalGradient(colors = listOf(gradient1, gradient2))
            ) {}

            Row(modifier = Modifier.align(CenterHorizontally)) {
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
    }
}

@Composable
fun AnnotatedClickableText() {
    val annotatedText =
        buildAnnotatedString {
            //append your initial text
            withStyle(
                style = SpanStyle(
                    color = Color.Gray,
                )
            ) {
                append("Don't have an account? ")
            }

            //Start of the pushing annotation which you want to color and make them clickable later
            pushStringAnnotation(
                tag = "SignUp",// provide tag which will then be provided when you click the text
                annotation = "SignUp"
            )
            //add text with your different color/style
            withStyle(
                style = SpanStyle(
                    color = Color.Red,
                )
            ) {
                append("Sign Up")
            }
            // when pop is called it means the end of annotation with current tag
            pop()
        }
    val context = LocalContext.current
    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = "SignUp",// tag which you used in the buildAnnotatedString
                start = offset,
                end = offset
            )[0].let { annotation ->
                //do your stuff when it gets clicked
                Toast.makeText(context,
                    "Hi Sehar Batool",
                    Toast.LENGTH_LONG).show()            }
        }
    )
}

@Composable
fun InputTextField(
    label:String,
    modifier: Modifier = Modifier
){

    OutlinedTextField(value = "", onValueChange = {},
        label = { Text(text = label,
            style = TextStyle(color = md_theme_light_primary,)
        ) },
        /*colors = TextFieldDefaults.outlinedTextFieldColors
            (unfocusedBorderColor = Color.Gray),*/
        placeholder = {
            Text(
                "",
                style = TextStyle(color = md_theme_light_secondary)
            )
        }
    )

}

@Composable
fun GradientButtoon(
    text: String,
    textColor: Color,
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
}

