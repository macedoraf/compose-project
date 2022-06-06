package br.com.rafa_macedo.mercadinho.presentation.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class MainViewState() {
    val forgotPasswordLabel = "Esqueci minha senha"
    val sighInButtonLabel = "Cadastrar-se"
    val passwordVisibilityLabel = "mostrar senha"
    val emailLabel: String = "E-mail"
    val passwordLabel: String = "Senha"
    val loginButtonLabel: String = "Login"

    var passwordValue by mutableStateOf("")
    var emailValue by mutableStateOf("")
    var isPasswordVisible by mutableStateOf(false)

}