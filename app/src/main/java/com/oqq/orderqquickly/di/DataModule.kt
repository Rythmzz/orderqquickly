package com.oqq.orderqquickly.di

import com.oqq.orderqquickly.data.local.AppPreferences
import com.securepreferences.SecurePreferences
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {
    single { providedSecurePreferences(androidApplication() as MyApplication) }
    single { providedAppSecurePreferences(get()) }
}
    fun providedSecurePreferences(app:MyApplication) : SecurePreferences{
        return SecurePreferences(app,"","miretty.xml")
    }

    fun providedAppSecurePreferences (sharedPreferences: SecurePreferences) :AppPreferences{
        return AppPreferences(sharedPreferences)
    }
