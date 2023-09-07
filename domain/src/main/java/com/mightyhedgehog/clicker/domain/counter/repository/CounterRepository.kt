package com.mightyhedgehog.clicker.domain.counter.repository

interface CounterRepository {

    suspend fun getCounter(): Long

    fun saveCounter(newValue: Long)
}
