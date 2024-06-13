package com.tricakrawala.cocktailsapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.tricakrawala.cocktailsapp.data.pref.AuthPreference
import com.tricakrawala.cocktailsapp.data.pref.dataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
class AuthPrefModule{

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context) : DataStore<Preferences> {
        return context.dataStore
    }


    @Provides
    @Singleton
    fun providePreference(dataStore: DataStore<Preferences>) : AuthPreference{
        return AuthPreference(dataStore)
    }
}