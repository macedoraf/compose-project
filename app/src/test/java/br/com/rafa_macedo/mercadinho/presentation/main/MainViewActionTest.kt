package br.com.rafa_macedo.mercadinho.presentation.main

import br.com.rafa_macedo.mercadinho.presentation.MainInteractor
import br.com.rafa_macedo.mercadinho.ui.MainActivity
import br.com.rafa_macedo.mercadinho.ui.SighInActivity
import io.mockk.spyk
import io.mockk.verify
import org.junit.Before
import org.junit.Test


internal class MainViewActionTest {

    lateinit var interactor: MainInteractor

    @Before
    fun setUp() {
        interactor = spyk()
    }

    @Test
    fun `execute MainViewActionGoToLogin should call MainActivity`() {
        val expected = MainActivity::class.java

        MainViewAction.GoToLogin.execute(interactor)

        verify {
            interactor.redirectActivity(expected)
        }
    }

    @Test
    fun `execute MainViewActionGoToSignIn should call SighInActivity`() {
        val expected = SighInActivity::class.java

        MainViewAction.GoToSignIn.execute(interactor)

        verify {
            interactor.redirectActivity(expected)
        }
    }
}