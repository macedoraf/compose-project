package br.com.rafa_macedo.mercadinho.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rafa_macedo.mercadinho.presentation.MainInteractor
import br.com.rafa_macedo.mercadinho.presentation.sighin.SighInEffects
import br.com.rafa_macedo.mercadinho.presentation.sighin.SighInViewModel
import br.com.rafa_macedo.mercadinho.presentation.sighin.SighInState
import br.com.rafa_macedo.mercadinho.ui.theme.MercadinhoTheme

class SighInActivity : ComponentActivity(), MainInteractor {

    private val viewModel: SighInViewModel = SighInViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewState by viewModel.viewState.collectAsState()
            val viewEffects = viewModel.viewEffects

            LaunchedEffect(key1 = viewEffects) {
                viewEffects.collect { effects ->
                    when (effects) {
                        SighInEffects.ShowDatePicker -> {}
                    }
                }
            }

            Screen(viewState = viewState)
        }
    }


    @Composable
    private fun Screen(viewState: SighInState) {
        LazyColumn(
            Modifier
        ) {
            items(items = viewState.textFieldStates.toList()) { keyValue ->
                keyValue.second.let { textFieldState ->
                    TextFieldRow(label = textFieldState.label,
                        text = textFieldState.text,
                        onTextChange = {
                            viewModel.onTextFieldChange(
                                keyValue.first,
                                textFieldState.copy(text = it)
                            )
                        })
                }
            }
        }
    }

//    Button(
//    onClick = { /*TODO*/ }, modifier = Modifier
//    .fillMaxWidth()
//    .padding(8.dp)
//    ) {
//        Text(text = "Cadastrar")
//    }

    @Composable
    private fun DatePickerRow(description: String) {
        Row {
            TextField(
                enabled = false,
                value = "",
                onValueChange = {},
                label = { Text(text = description) },
                maxLines = 1,
                modifier = Modifier
                    .clickable { viewModel.showDatePicker() }
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
    fun TextFieldRow(label: String?, text: String?, onTextChange: (String) -> Unit) {
        Row {
            TextField(
                value = text.orEmpty(),
                onValueChange = onTextChange,
                label = { Text(text = label.orEmpty()) },
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
        }
    }

    override fun redirectActivity(clazz: Class<*>) {
        redirectActivity(clazz)
    }
}