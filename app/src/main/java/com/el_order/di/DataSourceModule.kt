package com.el_order.di

import com.el_order.data.remote.auth.AuthRemoteDataSource
import com.el_order.data.remote.auth.AuthRemoteDataSourceImp
import com.el_order.data.remote.orders.OrdersRemoteDataSource
import com.el_order.data.remote.orders.OrdersRemoteDataSourceImp
import com.el_order.data.remote.products.ProductsRemoteDataSource
import com.el_order.data.remote.products.ProductsRemoteDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

// Install this module in Hilt-generated SingletonComponent
@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {
    @Binds
    abstract fun bindAuthRemoteDataSource(AuthRemoteDataSourceImp: AuthRemoteDataSourceImp): AuthRemoteDataSource

    @Binds
    abstract fun bindOrdersRemoteDataSource(ordersRemoteDataSource: OrdersRemoteDataSourceImp): OrdersRemoteDataSource

    @Binds
    abstract fun bindProductsRemoteDataSource(productsRemoteDataSourceImp: ProductsRemoteDataSourceImp): ProductsRemoteDataSource
}