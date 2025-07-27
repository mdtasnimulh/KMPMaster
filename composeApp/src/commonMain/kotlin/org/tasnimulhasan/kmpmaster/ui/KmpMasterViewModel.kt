package org.tasnimulhasan.kmpmaster.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasnimulhasan.kmpmaster.domain.usecase.GetIsFirstLaunchUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class KmpMasterViewModel(
    private val getIsFirstLaunchUseCase: GetIsFirstLaunchUseCase,
) : ViewModel() {

    private val _isFirstLaunch = MutableStateFlow<String?>(null)
    val isFirstLaunch = _isFirstLaunch.asStateFlow()

    init {
        fetchIsFirstLaunch()
    }

    private fun fetchIsFirstLaunch() {
        viewModelScope.launch {
            getIsFirstLaunchUseCase().firstOrNull()?.let {
                _isFirstLaunch.value = it
            }
        }
    }

}