package com.tasnimulhasan.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasnimulhasan.kmpmaster.domain.usecase.GetIsFirstLaunchUseCase
import com.tasnimulhasan.kmpmaster.domain.usecase.SetIsFirstLaunchUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Provided

@KoinViewModel
class HomeViewModel(
    @Provided private val setIsFirstLaunchUseCase: SetIsFirstLaunchUseCase,
    @Provided private val getIsFirstLaunchUseCase: GetIsFirstLaunchUseCase,
) : ViewModel() {

    private val _isFirstLaunch = MutableStateFlow("")
    val isFirstLaunch = _isFirstLaunch.asStateFlow()

    init {
        fetchIsFirstLaunch()
    }

    fun setIsFirstLaunch(isFirstLaunch: String) {
        viewModelScope.launch {
            println("Is First Launch Value: Calling set function")
            setIsFirstLaunchUseCase.invoke(isFirstLaunch)
            //fetchIsFirstLaunch()
        }
    }

    private fun fetchIsFirstLaunch() {
        viewModelScope.launch {
            getIsFirstLaunchUseCase().firstOrNull()?.let {
                _isFirstLaunch.value = it.toString()
                println("Is First Launch Value from view model: ${isFirstLaunch.value}")
            }
        }
    }

}