package br.com.rafa_macedo.mercadinho.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rafa_macedo.mercadinho.presentation.MainInteractor
import br.com.rafa_macedo.mercadinho.presentation.main.MainViewModel
import br.com.rafa_macedo.mercadinho.ui.theme.MercadinhoTheme
import br.com.rafa_macedo.mercadinho.utils.redirect

class MainActivity : ComponentActivity(), MainInteractor {

    private val viewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObservable()
        setContent {
            MercadinhoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FormLogin()
                }
            }
        }
    }

    private fun setupObservable() {
        viewModel.viewAction.observe(this) { it.execute(this) }
    }

    @Composable
    fun FormLogin() {
        Column {
            TextFieldRow(description = viewModel.viewState.emailLabel)
            TextFieldPasswordRow(description = viewModel.viewState.passwordLabel)
            ForgotPassword()
            LoginButton()
            SighInButton()

        }
    }

    @Composable
    private fun ForgotPassword() {
        Text(
            text = viewModel.viewState.forgotPasswordLabel,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }

    @Composable
    private fun SighInButton() {
        Button(
            onClick = viewModel::onSignInClick,
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Text(text = viewModel.viewState.sighInButtonLabel)
        }
    }

    @Composable
    fun LoginButton() {
        Button(
            onClick = viewModel::onLoginClick,
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = viewModel.viewState.loginButtonLabel)
        }
    }

    @Composable
    fun TextFieldRow(description: String) {
        Row {
            TextField(
                value = viewModel.viewState.emailValue,
                onValueChange = { viewModel.viewState.emailValue = it },
                label = { Text(text = description) },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
            )
        }
    }

    @Composable
    fun TextFieldPasswordRow(description: String) {
        Row {
            TextField(
                value = viewModel.viewState.passwordValue,
                onValueChange = { viewModel.viewState.passwordValue = it },
                label = { Text(text = description) },
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                visualTransformation = if (!viewModel.viewState.isPasswordVisible)
                    PasswordVisualTransformation()
                else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Go
                ),
                keyboardActions = KeyboardActions(onDone = { viewModel.onLoginClick() }) {},
                leadingIcon = {
                    IconButton(onClick = { viewModel.changePassVisibility() }) {
                        Icon(
                            imageVector = if (viewModel.viewState.isPasswordVisible) Icons.Filled.Visibility
                            else Icons.Filled.VisibilityOff,
                            contentDescription = viewModel.viewState.passwordVisibilityLabel
                        )
                    }
                },
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MercadinhoTheme {
            FormLogin()
        }
    }

    override fun redirectActivity(clazz: Class<*>) {
        redirect(clazz)
    }
}