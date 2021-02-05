package com.saad.maximatechtest.gateway.presentation

import com.saad.maximatechtest.utils.ConnectionManager
import javax.inject.Inject

class GatewayPresenter @Inject constructor(
    var view: GatewayContract.View?,
    private val connectionManager: ConnectionManager
) : GatewayContract.Presenter {

    override fun onClickCardClients() {
        view?.goToClient()
    }

    override fun onClickCardRequest() {
        view?.goToRequests()
    }

    override fun onClickCardSalesSummary() {
        view?.goToSalesSummary()
    }

    override fun onClickCardTools() {
        view?.goToSalesSummary()
    }

    override fun validateConnection() {
        if (connectionManager.isConnectionAvailable()) view?.showIconWithConnection()
        else view?.showIconWithoutConnection()
    }

    override fun detachView() {
        view = null
    }
}