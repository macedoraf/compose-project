package br.com.rafa_macedo.mercadinho.presentation.main

import br.com.rafa_macedo.mercadinho.ui.SighInActivity
import br.com.rafa_macedo.mercadinho.presentation.MainInteractor
import br.com.rafa_macedo.mercadinho.ui.MainActivity

sealed class MainViewAction {

    abstract fun execute(interactor: MainInteractor)

    object GoToLogin : MainViewAction() {
        override fun execute(interactor: MainInteractor) {
            interactor.redirectActivity(MainActivity::class.java)
        }
    }

    object GoToSignIn : MainViewAction() {
        override fun execute(interactor: MainInteractor) {
            interactor.redirectActivity(SighInActivity::class.java)
        }
    }
}
