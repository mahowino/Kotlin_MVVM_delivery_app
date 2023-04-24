package online.kenya.myapplication.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import online.kenya.myapplication.feature_orders.data.data_source.OrderDatabase
import online.kenya.myapplication.feature_orders.data.repository.OrderRepositoryImpl
import online.kenya.myapplication.feature_orders.domain.repository.OrderRepository
import online.kenya.myapplication.feature_orders.domain.use_cases.CallOrderGiverUseCase
import online.kenya.myapplication.feature_orders.domain.use_cases.GetOrdersUseCase
import online.kenya.myapplication.feature_orders.domain.use_cases.OrderUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule (
    private val application: Application
    ){


    @Provides
    @Singleton
    fun provideOrderDatabase(app: Application):OrderDatabase{
        return Room.databaseBuilder(
            app,
            OrderDatabase::class.java,
            OrderDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideOrderRepository(db:OrderDatabase):OrderRepository{
        return OrderRepositoryImpl(db.orderDao)
    }

    @Provides
    @Singleton
    fun providesOrderUseCases(repository: OrderRepository):OrderUseCases{
        return OrderUseCases(
            getOrders = GetOrdersUseCase(repository),
            callOrderGiver = CallOrderGiverUseCase(repository,application)
        )
    }
}