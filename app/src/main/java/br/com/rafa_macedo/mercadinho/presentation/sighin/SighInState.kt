package br.com.rafa_macedo.mercadinho.presentation.sighin

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateMap

data class SighInState(
    val birthDayState: BirthdayState,
    val textFieldStates: SnapshotStateMap<Int, TextFieldState>,
    val submitButtonState: SubmitButtonState
) {


    data class SubmitButtonState(val description: String) {
        companion object {
            val Initial = SubmitButtonState("Cadastrar")
        }
    }

    companion object {
        private const val NAME = 0
        private const val LAST_NAME = 1

        private val initialTextFields = mutableStateMapOf(
            NAME to TextFieldState.initial(label = "Nome"),
            LAST_NAME to TextFieldState.initial(label = "Sobrenome")
        )

        val Initial = SighInState(
            BirthdayState.Initial,
            initialTextFields,
            SighInState.SubmitButtonState.Initial
        )
    }

    data class TextFieldState(
        val isEnable: Boolean,
        val label: String?,
        val text: String?
    ) {
        companion object {
            fun initial(label: String?) =
                TextFieldState(isEnable = true, label = label, text = null)
        }
    }

    data class BirthdayState(
        val isEnable: Boolean,
        val dateValue: String,
        val errorMessage: String?
    ) {
        companion object {
            val Initial = BirthdayState(false, "", null)
        }
    }
}