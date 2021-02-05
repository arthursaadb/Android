package com.saad.maximatechtest.gateway.di

import androidx.fragment.app.Fragment
import com.saad.maximatechtest.gateway.presentation.GatewayContract
import com.saad.maximatechtest.gateway.presentation.GatewayFragment
import com.saad.maximatechtest.gateway.presentation.GatewayPresenter
import com.saad.maximatechtest.utils.AppConnectivityManager
import com.saad.maximatechtest.utils.ConnectionManager
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
abstract class GatewayModule {
    @Binds
    abstract fun bindsGatewayFragment(gatewayFragment: GatewayFragment): GatewayContract.View

    @Binds
    abstract fun bindsGatewayPresenter(gatewayPresenter: GatewayPresenter): GatewayContract.Presenter

    @Binds
    abstract fun bindsConnectivityManager(appConnectivityManager: AppConnectivityManager): ConnectionManager

    companion object {
        @Provides
        fun providesGatewayFragment(fragment: Fragment) = fragment as GatewayFragment
    }
}