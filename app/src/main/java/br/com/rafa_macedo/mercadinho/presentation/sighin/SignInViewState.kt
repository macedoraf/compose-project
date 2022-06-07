package br.com.rafa_macedo.mercadinho.presentation.sighin

data class SignInViewState(
    val birthDayState: BirthdayState,
    var nameState: TextFieldState
) {

    companion object {
        val Initial = SignInViewState(BirthdayState.Initial, TextFieldState.Initial)
    }


    data class TextFieldState(
        val isEnable: Boolean,
        val label: String?,
        val text: String?
    ) {
        companion object {
            val Initial = TextFieldState(isEnable = true, label = null, text = null)
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