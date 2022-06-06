package br.com.rafa_macedo.mercadinho.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rafa_macedo.mercadinho.presentation.MainInteractor
import br.com.rafa_macedo.mercadinho.presentation.main.MainViewAction
import br.com.rafa_macedo.mercadinho.presentation.main.MainViewModel
import br.com.rafa_macedo.mercadinho.presentation.sighin.SighInViewModel
import br.com.rafa_macedo.mercadinho.ui.theme.MercadinhoTheme
import com.google.accompanist.insets.ProvideWindowInsets

class SighInActivity : ComponentActivity(), MainInteractor {

    private val viewModel: SighInViewModel = SighInViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObservable()
        setContent {
            MercadinhoTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProvideWindowInsets() {
                        FormSighIn()
                    }

                }
            }
        }
    }

    private fun setupObservable() {
    }

    @Composable
    fun FormSighIn() {
        Column(
            Modifier
                .fillMaxHeight()
                .verticalScroll(
                    state = rememberScrollState()
                )
        ) {
            TextFieldRow(description = "Nome")
            TextFieldRow(description = "Sobrenome")
            TextFieldRow(description = "Data de nascimento")
            TextFieldRow(description = "Telefone")
            TextFieldRow(description = "E-mail")
            TextFieldRow(description = "Confirmação de E-mail")
            TextFieldRow(description = "Senha")
            TextFieldRow(description = "Confirmação de senha")
            Button(
                onClick = { /*TODO*/ }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = "Cadastrar")
            }
        }
    }

    @Composable
    fun TextFieldRow(description: String) {
        Row {
            TextField(
                value = "",
                onValueChange = { },
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

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MercadinhoTheme {
            FormSighIn()
        }
    }

    override fun redirectActivity(clazz: Class<*>) {
        redirectActivity(clazz)
    }
}