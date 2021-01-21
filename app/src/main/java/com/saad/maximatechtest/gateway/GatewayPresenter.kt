package com.saad.maximatechtest.gateway

import com.saad.maximatechtest.utils.ConnectionManager

class GatewayPresenter(var view: GatewayContract.View?, val connectionManager: ConnectionManager) :
    GatewayContract.Presenter {
    override fun onClickCardClients() {

    }

    override fun onClickCardRequest() {

    }

    override fun onClickCardSalesSummary() {

    }

    override fun onClickCardTools() {

    }

    override fun validateConnection() {
        if (connectionManager.isConnectionAvailable()) view?.showIconWithConnection()
        else view?.showIconWithoutConnection()
    }

    override fun detachView() {
        view = null
    }
}