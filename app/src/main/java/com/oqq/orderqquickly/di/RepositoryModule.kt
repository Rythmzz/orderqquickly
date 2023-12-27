package com.oqq.orderqquickly.di

import com.oqq.orderqquickly.repo.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single { Repository(get()) }

}