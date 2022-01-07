package com.el_order.di

import com.el_order.data.remote.products.ProductsRepositoryImp
import com.el_order.data.repository.auth.AuthRepository
import com.el_order.data.repository.auth.AuthRepositoryImp
import com.el_order.data.repository.orders.OrdersRepository
import com.el_order.data.repository.orders.OrdersRepositoryImp
import com.el_order.data.repository.products.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindAuthRepository(authRepository: AuthRepositoryImp): AuthRepository

    @Binds
    abstract fun bindProductsRepository(productsRepository: ProductsRepositoryImp): ProductsRepository

    @Binds
    abstract fun bindOrdersRepository(ordersRepository: OrdersRepositoryImp): OrdersRepository

}