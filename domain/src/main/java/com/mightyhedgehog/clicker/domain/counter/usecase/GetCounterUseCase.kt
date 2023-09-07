package com.mightyhedgehog.clicker.domain.counter.usecase

import com.mightyhedgehog.clicker.domain.counter.repository.CounterRepository

class GetCounterUseCase(private val counterRepository: CounterRepository) {

    suspend operator fun invoke() = counterRepository.getCounter()
}
