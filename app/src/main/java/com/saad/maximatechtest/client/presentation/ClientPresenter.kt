package com.saad.maximatechtest.client.presentation

import com.saad.maximatechtest.client.business.model.ClientModel
import com.saad.maximatechtest.client.business.model.vo.ClientInfoVO
import com.saad.maximatechtest.client.business.repository.ClientRepository
import com.saad.maximatechtest.utils.Status
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ClientPresenter @Inject constructor(
    var view: ClientContract.View?,
    private val clientRepository: ClientRepository,
    private val clientModel: ClientModel
) :
    ClientContract.Presenter, CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    override fun getClientInfo() {
        launch {
            val response = clientRepository.getClientInfo()

            withContext(Dispatchers.Main) {
                when (response.status) {
                    Status.SUCCESS -> handleSuccess(response.data)
                    Status.ERROR -> handleError(response.message)
                }
            }
        }
    }

    private fun handleSuccess(data: ClientInfoVO?) {
        data?.let {
            clientModel.client = it
            clientModel.contacts = it.contacts

            showClientInfo()
            showContactsInfo()
        }
    }

    private fun showClientInfo() {

        view?.apply {
            showCompanyNameWithCode(clientModel.getCompanyNameWithCode())
            showFantasyName(clientModel.getFantasyName())
            showCpf(clientModel.getCpf())
            showCnpj(clientModel.getCnpj())
            showActivityBranch(clientModel.getActivityBranch())
            showAddress(clientModel.getAddress())
        }
    }

    private fun showContactsInfo() {

    }

    private fun handleError(message: String?) {

    }

    override fun unbindView() {
        coroutineContext.cancel()
        view = null
    }
}