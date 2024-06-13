package com.tricakrawala.cocktailsapp.data.pref

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

annotation class SessionDataStore

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "auth_session")


class AuthPreference @Inject constructor(@SessionDataStore private val dataStore: DataStore<Preferences>) {

    suspend fun saveSession(auth : AuthModel) {
        dataStore.edit { preferences ->
            preferences[EMAIL] = auth.email
            preferences[NAME] = auth.name
            preferences[IS_LOGIN] = auth.isLogin
            Log.d(TAG, "saveSession: $auth")
        }
    }


    fun getSession(): Flow<AuthModel> {
        return dataStore.data.map { preferences ->
            AuthModel(
                preferences[EMAIL] ?: "",
                preferences[NAME] ?: "",
                preferences[IS_LOGIN] ?: false,

                )
        }
    }

    suspend fun logout() {
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object {
        private const val TAG = "Preference"

        private val IS_LOGIN = booleanPreferencesKey("isLogin")
        private val NAME = stringPreferencesKey("name")
        private val EMAIL = stringPreferencesKey("email")
    }
}