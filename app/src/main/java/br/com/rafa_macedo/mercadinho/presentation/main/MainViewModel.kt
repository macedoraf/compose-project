package br.com.rafa_macedo.mercadinho.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val viewState = MainViewState()
    val viewAction = MutableLiveData<MainViewAction>()

    fun onLoginClick() {
        viewAction.postValue(MainViewAction.GoToLogin)
    }

    fun onSignInClick() {
        viewAction.postValue(MainViewAction.GoToSignIn)
    }

    fun changePassVisibility() {
        viewState.isPasswordVisible = !viewState.isPasswordVisible
    }
}