package com.saad.maximatechtest.gateway

interface GatewayContract {

    interface View {
        fun goToClientData()
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