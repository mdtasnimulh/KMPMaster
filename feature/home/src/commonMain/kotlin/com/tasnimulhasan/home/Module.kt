package com.tasnimulhasan.home

import com.tasnimulhasan.kmpmaster.domain.di.domainModule
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val homeModule = module {
    includes(domainModule)
    viewModelOf(::HomeViewModel)
}