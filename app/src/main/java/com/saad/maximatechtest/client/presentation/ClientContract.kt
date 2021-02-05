package com.saad.maximatechtest.client.presentation

interface ClientContract {
    interface View {
        fun showCompanyNameWithCode(name: String)
        fun showFantasyName(fantasyName: String)
        fun showCpf(cpf: String)
        fun showCnpj(cnpj: String)
        fun showActivityBranch(activityBranch: String)
        fun showAddress(address: String)
    }

    interface Presenter {
        fun getClientInfo()
        fun unbindView()
    }
}