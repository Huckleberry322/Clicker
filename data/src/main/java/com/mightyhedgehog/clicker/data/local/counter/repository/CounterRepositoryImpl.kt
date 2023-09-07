package com.mightyhedgehog.clicker.data.local.counter.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.mightyhedgehog.clicker.domain.counter.repository.CounterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CounterRepositoryImpl(private val counterDataStore: DataStore<Preferences>) :
    CounterRepository {

    companion object {
        private val CounterKey = longPreferencesKey("counter")

        private const val COUNTER_INITIAL = 0L
    }

    private val counter: Flow<Long> = counterDataStore.data
        .map { preferences ->
            preferences[CounterKey] ?: COUNTER_INITIAL
        }

    override suspend fun getCounter(): Long = counter.first()

    override fun saveCounter(newValue: Long) {
        CoroutineScope(Dispatchers.IO).launch {
            counterDataStore.edit { preferences ->
                preferences[CounterKey] = newValue
            }
        }
    }
}

private const val CounterDataStoreName = "counter_datastore"

val Context.counterDataStore: DataStore<Preferences> by preferencesDataStore(name = CounterDataStoreName)
