package com.el_order.di

import com.el_order.data.remote.auth.AuthApi
import com.el_order.data.remote.orders.OrdersApi
import com.el_order.data.remote.products.ProductsApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
 * Network API communication setup via Retrofit.
 */
private const val BASE_URL = ""

// Install this module in Hilt-generated SingletonComponent
@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    /**
     * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
     * full Kotlin compatibility.
     */
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    // Makes Hilt provide Retrofit instance when a Retrofit type is requested
    @Provides
    @Singleton
    fun providesAuthApi(): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }

    // Makes Hilt provide Retrofit instance when a Retrofit type is requested
    @Provides
    @Singleton
    fun providesOrdersApi(): OrdersApi {
        return retrofit.create(OrdersApi::class.java)
    }    // Makes Hilt provide Retrofit instance when a Retrofit type is requested

    @Provides
    @Singleton
    fun providesProductsApi(): ProductsApi {
        return retrofit.create(ProductsApi::class.java)
    }
}