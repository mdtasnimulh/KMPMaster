package com.tasnimulhasan.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasnimulhasan.kmpmaster.domain.usecase.GetIsFirstLaunchUseCase
import com.tasnimulhasan.kmpmaster.domain.usecase.SetIsFirstLaunchUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class HomeViewModel(
    private val setIsFirstLaunchUseCase: SetIsFirstLaunchUseCase,
    private val getIsFirstLaunchUseCase: GetIsFirstLaunchUseCase,
) : ViewModel() {

    private val _isFirstLaunch = MutableStateFlow(false)
    val isFirstLaunch = _isFirstLaunch.asStateFlow()

    init {
        fetchIsFirstLaunch()
    }

    fun setIsFirstLaunch(isFirstLaunch: Boolean) {
        viewModelScope.launch {
            setIsFirstLaunchUseCase.invoke(isFirstLaunch)
        }
    }

    private fun fetchIsFirstLaunch() {
        viewModelScope.launch {
            getIsFirstLaunchUseCase().firstOrNull()?.let {
                _isFirstLaunch.value = it
            }
        }
    }

}