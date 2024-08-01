package com.example.sports.ViewModel

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.sports.model.UsuarioModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginViewModel : ViewModel() {

    var state by mutableStateOf(UsuarioModel())
        private set

    private lateinit var auth: FirebaseAuth

    fun onValue(value: String, key: String) {
        when (key) {
            "correo" -> state = state.copy(correo = value)
            "contrasena" -> state = state.copy(contrasena = value)
        }
    }

    fun loginUser(navController: NavController, context: Context) {
        auth = Firebase.auth
        auth.signInWithEmailAndPassword(state.correo, state.contrasena)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    // Aquí puedes manejar la navegación después del inicio de sesión exitoso
                    navController.navigate("MainHome")
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        context,
                        "Inicio de sesión incorrecto, verifique sus datos.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }
}

