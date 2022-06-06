package br.com.rafa_macedo.mercadinho.presentation.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule


internal class MainViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun `onLoginClick should post goToLoginAction`() {
        val expected = MainViewAction.GoToLogin

        viewModel.onLoginClick()

        assertEquals(viewModel.viewAction.value, expected)
    }

    @Test
    fun `onSignInClick should post goToSighInAction`() {
        val expected = MainViewAction.GoToSignIn

        viewModel.onSignInClick()

        assertEquals(viewModel.viewAction.value, expected)
    }

    @Test
    fun `changePassVisibility should invert visibilityToggle`() {
        val expected = !viewModel.viewState.isPasswordVisible

        viewModel.changePassVisibility()

        assertEquals(viewModel.viewState.isPasswordVisible, expected)
    }
}