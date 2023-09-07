package com.mightyhedgehog.clicker.domain.counter.di

import com.mightyhedgehog.clicker.domain.counter.usecase.GetCounterUseCase
import com.mightyhedgehog.clicker.domain.counter.usecase.SaveCounterUseCase
import org.koin.dsl.module

val UseCaseModule = module {
    factory { GetCounterUseCase(counterRepository = get()) }
    factory { SaveCounterUseCase(counterRepository = get()) }
}
