package org.tasnimulhasan.kmpmaster.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasnimulhasan.home.HomeRoute
import com.tasnimulhasan.kmpmaster.domain.usecase.GetIsFirstLaunchUseCase
import com.tasnimulhasan.onboarding.OnboardingRoute
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class KmpMasterViewModel(
    private val getIsFirstLaunchUseCase: GetIsFirstLaunchUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading(false))
    val uiState get() = _uiState

    private val _isFirstLaunch = MutableStateFlow<String?>(null)
    val isFirstLaunch = _isFirstLaunch.asStateFlow()

    init {
        fetchIsFirstLaunch()
    }

    private fun fetchIsFirstLaunch() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading(true)
            getIsFirstLaunchUseCase().firstOrNull()?.let {
                _isFirstLaunch.value = it
                _uiState.value = UiState.Loading(false)
                _uiState.value = UiState.Ready
            }
        }
    }

    fun determineStartDestination(): Any {
        val isFirstLaunch = isFirstLaunch.value
        return if (isFirstLaunch == "Y") {
            OnboardingRoute
        } else {
            HomeRoute
        }
    }

}

sealed interface UiState {
    data class Loading(val isLoading: Boolean): UiState
    data object Ready: UiState
}