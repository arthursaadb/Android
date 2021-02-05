package com.saad.maximatechtest.client.business.model

import com.saad.maximatechtest.client.business.model.vo.ClientInfoVO
import com.saad.maximatechtest.client.business.model.vo.ContactVO

data class ClientModel(
    var client: ClientInfoVO? = null,
    var contacts: List<ContactVO>? = null
) {
    fun hasContacts(): Boolean = contacts?.isEmpty() ?: false

    fun getCompanyNameWithCode() = client?.code + "-" + client?.companyName

    fun getFantasyName() = client?.fantasyName ?: ""

    fun getCpf(): String = client?.cpf ?: kotlin.run { "Não informado" }

    fun getCnpj(): String = client?.cnpj ?: kotlin.run { "Não informado" }

    fun getActivityBranch(): String = client?.activityBranch ?: kotlin.run { "Não informado" }

    fun getAddress(): String = client?.address ?: kotlin.run { "Não informado" }
}

