package com.example.sports.View

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sports.R
import com.example.sports.ViewModel.RegistroViewModel
import com.example.sports.ui.theme.gradient1
import com.example.sports.ui.theme.gradient2
import com.example.sports.ui.theme.md_theme_light_primary
import com.example.sports.ui.theme.md_theme_light_secondary



@Composable
fun RegistroView(navController: NavController, viewModel: RegistroViewModel){

    var passwordVisible by remember { mutableStateOf(false)}
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    val dataU = viewModel.state


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
                modifier = Modifier.padding(top = 0.dp),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 35.sp
            )

            Spacer(modifier = Modifier.height(30.dp))


            OutlinedTextField(
                value = dataU.nombre,
                onValueChange = { viewModel.onValue(it, "nombre") },
                label = { Text("Nombre") },
                modifier = Modifier
                    .fillMaxWidth(),
                //.clip(RoundedCornerShape(18.dp)),
                singleLine = true,
                maxLines = 1,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
            )



            OutlinedTextField(
                value = dataU.correo,
                onValueChange = { viewModel.onValue(it, "correo") },
                label = { Text("Correo ") },
                modifier = Modifier
                    .fillMaxWidth(),
                //.clip(RoundedCornerShape(8.dp)),
                singleLine = true,
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    focusManager.moveFocus(
                        FocusDirection.Down
                    )
                })
            )


            OutlinedTextField(
                value = dataU.contrasena,
                onValueChange = { viewModel.onValue(it, "contrasena") },
                label = { Text("Contraseña") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                maxLines = 1,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = "Toggle password visibility"
                        )
                    }
                }
            )
            Button(
                onClick = {
                    if (dataU.nombre.isEmpty() || dataU.correo.isEmpty()
                        || dataU.contrasena.isEmpty()
                    ) {
                        Toast.makeText(context, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
                    } else {
                        //viewModel.registerUser(navController, context)
                        viewModel.fetchData(navController, context)
                    }
                }
            ) {
                Text("Enviar")
            }





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
                        .clickable {
                            navController.navigate("login_view")
                        }
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

private val Icons.Filled.Visibility: ImageVector
    get() {
        if (_visibility != null) {
            return _visibility!!
        }
        _visibility =
            materialIcon(name = "Filled.Visibility") {
                materialPath {
                    moveTo(12.0f, 4.5f)
                    curveTo(7.0f, 4.5f, 2.73f, 7.61f, 1.0f, 12.0f)
                    curveToRelative(1.73f, 4.39f, 6.0f, 7.5f, 11.0f, 7.5f)
                    reflectiveCurveToRelative(9.27f, -3.11f, 11.0f, -7.5f)
                    curveToRelative(-1.73f, -4.39f, -6.0f, -7.5f, -11.0f, -7.5f)
                    close()
                    moveTo(12.0f, 17.0f)
                    curveToRelative(-2.76f, 0.0f, -5.0f, -2.24f, -5.0f, -5.0f)
                    reflectiveCurveToRelative(2.24f, -5.0f, 5.0f, -5.0f)
                    reflectiveCurveToRelative(5.0f, 2.24f, 5.0f, 5.0f)
                    reflectiveCurveToRelative(-2.24f, 5.0f, -5.0f, 5.0f)
                    close()
                    moveTo(12.0f, 9.0f)
                    curveToRelative(-1.66f, 0.0f, -3.0f, 1.34f, -3.0f, 3.0f)
                    reflectiveCurveToRelative(1.34f, 3.0f, 3.0f, 3.0f)
                    reflectiveCurveToRelative(3.0f, -1.34f, 3.0f, -3.0f)
                    reflectiveCurveToRelative(-1.34f, -3.0f, -3.0f, -3.0f)
                    close()
                }
            }
        return _visibility!!
    }

private var _visibility: ImageVector? = null

private val Icons.Filled.VisibilityOff: ImageVector
    get() {
        if (_visibilityOff != null) {
            return _visibilityOff!!
        }
        _visibilityOff =
            materialIcon(name = "Filled.VisibilityOff") {
                materialPath {
                    moveTo(12.0f, 7.0f)
                    curveToRelative(2.76f, 0.0f, 5.0f, 2.24f, 5.0f, 5.0f)
                    curveToRelative(0.0f, 0.65f, -0.13f, 1.26f, -0.36f, 1.83f)
                    lineToRelative(2.92f, 2.92f)
                    curveToRelative(1.51f, -1.26f, 2.7f, -2.89f, 3.43f, -4.75f)
                    curveToRelative(-1.73f, -4.39f, -6.0f, -7.5f, -11.0f, -7.5f)
                    curveToRelative(-1.4f, 0.0f, -2.74f, 0.25f, -3.98f, 0.7f)
                    lineToRelative(2.16f, 2.16f)
                    curveTo(10.74f, 7.13f, 11.35f, 7.0f, 12.0f, 7.0f)
                    close()
                    moveTo(2.0f, 4.27f)
                    lineToRelative(2.28f, 2.28f)
                    lineToRelative(0.46f, 0.46f)
                    curveTo(3.08f, 8.3f, 1.78f, 10.02f, 1.0f, 12.0f)
                    curveToRelative(1.73f, 4.39f, 6.0f, 7.5f, 11.0f, 7.5f)
                    curveToRelative(1.55f, 0.0f, 3.03f, -0.3f, 4.38f, -0.84f)
                    lineToRelative(0.42f, 0.42f)
                    lineTo(19.73f, 22.0f)
                    lineTo(21.0f, 20.73f)
                    lineTo(3.27f, 3.0f)
                    lineTo(2.0f, 4.27f)
                    close()
                    moveTo(7.53f, 9.8f)
                    lineToRelative(1.55f, 1.55f)
                    curveToRelative(-0.05f, 0.21f, -0.08f, 0.43f, -0.08f, 0.65f)
                    curveToRelative(0.0f, 1.66f, 1.34f, 3.0f, 3.0f, 3.0f)
                    curveToRelative(0.22f, 0.0f, 0.44f, -0.03f, 0.65f, -0.08f)
                    lineToRelative(1.55f, 1.55f)
                    curveToRelative(-0.67f, 0.33f, -1.41f, 0.53f, -2.2f, 0.53f)
                    curveToRelative(-2.76f, 0.0f, -5.0f, -2.24f, -5.0f, -5.0f)
                    curveToRelative(0.0f, -0.79f, 0.2f, -1.53f, 0.53f, -2.2f)
                    close()
                    moveTo(11.84f, 9.02f)
                    lineToRelative(3.15f, 3.15f)
                    lineToRelative(0.02f, -0.16f)
                    curveToRelative(0.0f, -1.66f, -1.34f, -3.0f, -3.0f, -3.0f)
                    lineToRelative(-0.17f, 0.01f)
                    close()
                }
            }
        return _visibilityOff!!
    }
private var _visibilityOff: ImageVector? = null


