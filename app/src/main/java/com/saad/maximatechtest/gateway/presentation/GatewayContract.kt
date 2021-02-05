package com.saad.maximatechtest.gateway.presentation

interface GatewayContract {

    interface View {
        fun goToClient()
        fun goToRequests()
        fun goToSalesSummary()
        fun goToTools()
        fun showIconWithConnection()
        fun showIconWithoutConnection()
    }


    interface Presenter {
        fun onClickCardClients()
        fun onClickCardRequest()
        fun onClickCardSalesSummary()
        fun onClickCardTools()
        fun detachView()
        fun validateConnection()
    }
}