package com.saad.maximatechtest.client.di

import androidx.fragment.app.Fragment
import com.saad.maximatechtest.client.business.datasource.local.LocalDataSource
import com.saad.maximatechtest.client.business.datasource.local.LocalDataSourceImpl
import com.saad.maximatechtest.client.business.datasource.remote.ClientService
import com.saad.maximatechtest.client.business.datasource.remote.RemoteDataSource
import com.saad.maximatechtest.client.business.datasource.remote.RemoteDataSourceImpl
import com.saad.maximatechtest.client.business.model.ClientModel
import com.saad.maximatechtest.client.business.repository.ClientRepository
import com.saad.maximatechtest.client.business.repository.ClientRepositoryImpl
import com.saad.maximatechtest.client.presentation.ClientContract
import com.saad.maximatechtest.client.presentation.ClientFragment
import com.saad.maximatechtest.client.presentation.ClientPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import retrofit2.Retrofit

@Module
@InstallIn(FragmentComponent::class)
abstract class ClientModule {
    @Binds
    abstract fun bindsClientFragment(clientFragment: ClientFragment): ClientContract.View

    @Binds
    abstract fun bindsClientPresenter(clientPresenter: ClientPresenter): ClientContract.Presenter

    @Binds
    abstract fun bindsClientRepository(clientRepositoryImpl: ClientRepositoryImpl): ClientRepository

    @Binds
    abstract fun bindsRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    abstract fun bindsLocalDataSource(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource

    companion object {
        @Provides
        fun providesClientModel() = ClientModel()

        @Provides
        fun providesClientService(retrofit: Retrofit): ClientService =
            retrofit.create(ClientService::class.java)

        @Provides
        fun providesFragment(fragment: Fragment): ClientFragment = fragment as ClientFragment
    }
}