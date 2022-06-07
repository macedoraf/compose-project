package br.com.rafa_macedo.mercadinho.presentation.sighin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rafa_macedo.mercadinho.utils.SingleShotEventBus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SighInViewModel : ViewModel() {

    //View States
    private val _viewState = MutableStateFlow(SighInState.Initial)
    val viewState = _viewState.asStateFlow()

    // Actions
    private val pendingActions = MutableSharedFlow<SighInAction>()

    //Effects
    private val _viewEffects = SingleShotEventBus<SighInEffects>()
    val viewEffects: Flow<SighInEffects> = _viewEffects.events

    private fun onComponentStateChange(componentState: SighInState) {
        viewModelScope.launch {
            _viewState.emit(componentState)
        }
    }

    init {
        viewModelScope.launch {
            pendingActions.collect {
                when (it) {
                    SighInAction.Submit -> {}
                    SighInAction.ShowDatePicker -> {}
                }
            }
        }
    }

    fun showDatePicker() {
        viewModelScope.launch {
            pendingActions.emit(SighInAction.ShowDatePicker)
            _viewEffects.postEvent(SighInEffects.ShowDatePicker)

        }
    }

    fun submitForm() {
        viewModelScope.launch {
            pendingActions.emit(SighInAction.Submit)
        }
    }

    fun onTextFieldChange(key: Int, value: SighInState.TextFieldState) {
        val newState = _viewState.value.copy()
        newState.textFieldStates.replace(key, value)
        onComponentStateChange(newState)
    }
}