package com.example.sports.ViewModel

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.sports.model.DatosUModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.database
import kotlinx.coroutines.launch

class RegistroViewModel: ViewModel() {

    var state by mutableStateOf(DatosUModel())
        private set

    var isLoading by mutableStateOf(false)
        private set

    private lateinit var auth: FirebaseAuth
    private val database = Firebase.database.reference

    val fecha_creacion = System.currentTimeMillis()

    fun fetchData(navController: NavController, context: Context) {
        viewModelScope.launch {
            try {
                isLoading = true
                registerUser(navController, context)
            } catch (e: Exception) {
                println("Error ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }


    fun onValue(value: String, key: String){
        when(key){
            "nombre"-> state = state.copy(nombre = value)
            "correo"-> state = state.copy(correo = value)
            "contrasena"-> state = state.copy(contrasena = value)

        }

    }

    var show by mutableStateOf(false)
        private set

    var showDialog by mutableStateOf(false)

    fun enviar() {
        show = true
    }

    fun openDialog() {
        showDialog = true
    }

    fun closeDialog() {
        showDialog = false
    }

    private suspend fun registerUser(navController: NavController, context: Context) {
        auth = Firebase.auth
        auth.createUserWithEmailAndPassword(state.correo, state.contrasena)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Registro exitoso, guarda los datos adicionales en la base de datos
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    user?.let {
                        val userId = it.uid
                        database.child("usuario").child(userId).setValue(state)
                            .addOnCompleteListener { dbTask ->
                                if (dbTask.isSuccessful) {
                                    // Datos guardados exitosamente, navega a la siguiente pantalla
                                    navController.navigate("MainHome")
                                } else {
                                    Log.w(TAG, "setValue:failure", dbTask.exception)
                                    Toast.makeText(
                                        context,
                                        "Failed to save user data.",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                    }
                } else {
                    // Si el registro falla, muestra un mensaje al usuario
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        context,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

}


