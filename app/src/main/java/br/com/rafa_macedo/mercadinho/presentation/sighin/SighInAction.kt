package br.com.rafa_macedo.mercadinho.presentation.sighin

sealed class SighInAction {
    object Submit : SighInAction()
    object ShowDatePicker : SighInAction()
}
