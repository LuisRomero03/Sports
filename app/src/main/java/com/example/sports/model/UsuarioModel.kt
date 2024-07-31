package com.example.sports.model

data class UsuarioModel(
    val correo: String,
    val contrasena: String
){
    constructor(): this ("" , "")

}
