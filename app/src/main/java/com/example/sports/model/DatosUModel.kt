package com.example.sports.model

data class DatosUModel(
    val nombre: String,
    val correo: String,
    val contrasena: String

){
    constructor(): this ("","","")
}
