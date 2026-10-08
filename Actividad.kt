/**
 * Crea un sistema de gestión de usuarios con data class Usuario, enum Rol (ADMIN, EDITOR, VISITANTE).
 */

enum class Rol {
    ADMIN, EDITOR, VISITANTE
}

interface Autenticable {
    fun iniciarSesion(): Boolean
}

data class Usuario(
    val nombre: String,
    val rol: Rol
) : Autenticable {

    override fun iniciarSesion(): Boolean {
        return true
    }
}

object GestorUsuarios {

    val usuarios = mutableListOf<Usuario>()

    fun registrar(usuario: Usuario) {
        usuarios.add(usuario)
        println("Usuario registrado: ${usuario.nombre}")
    }

    fun mostrarRol(usuario: Usuario) {
        when (usuario.rol) {
            Rol.ADMIN -> println("Es administrador")
            Rol.EDITOR -> println("Puede editar")
            Rol.VISITANTE -> println("Puede consultar")
        }
    }
}

fun main() {

    val usuario1 = Usuario("Mario", Rol.ADMIN)
    val usuario2 = Usuario("Maria", Rol.EDITOR)
    val usuario3 = Usuario("Alejandra", Rol.VISITANTE)

    GestorUsuarios.registrar(usuario1)
    GestorUsuarios.registrar(usuario2)
    GestorUsuarios.registrar(usuario3)

    println("\n--- Roles de los usuarios ---")

    GestorUsuarios.mostrarRol(usuario1)
    GestorUsuarios.mostrarRol(usuario2)
    GestorUsuarios.mostrarRol(usuario3)

    println("\n--- Inicio de sesión ---")
    println(usuario1.iniciarSesion())
}