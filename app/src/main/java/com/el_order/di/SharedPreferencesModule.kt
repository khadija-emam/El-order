package com.el_order.di

import android.content.Context
import android.content.SharedPreferences
import com.el_order.data.sharedpreferences.SharedPreferencesManager
import com.el_order.data.sharedpreferences.SharedPreferencesManagerImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class SharedPreferencesModule {

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            "el_order",
            Context.MODE_PRIVATE
        )
    }

    @Provides
    @Singleton
    fun bindSharedPreferenceStorage(sharedPreferences: SharedPreferences): SharedPreferencesManager {
        return SharedPreferencesManagerImp(sharedPreferences)
    }
}