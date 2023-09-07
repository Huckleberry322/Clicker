package com.mightyhedgehog.clicker.data.di

import com.mightyhedgehog.clicker.data.local.counter.repository.CounterRepositoryImpl
import com.mightyhedgehog.clicker.data.local.counter.repository.counterDataStore
import com.mightyhedgehog.clicker.domain.counter.repository.CounterRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val RepositoryModule = module {
    single<CounterRepository> { CounterRepositoryImpl(counterDataStore = androidContext().counterDataStore) }
}
