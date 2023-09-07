package com.mightyhedgehog.clicker.domain.counter.usecase

import com.mightyhedgehog.clicker.domain.counter.repository.CounterRepository

class SaveCounterUseCase(private val counterRepository: CounterRepository) {

    operator fun invoke(newValue: Long) = counterRepository.saveCounter(newValue)
}
