package com.saad.maximatechtest.client.business.repository

import com.saad.maximatechtest.client.business.model.vo.ClientInfoVO
import com.saad.maximatechtest.utils.Resource

interface ClientRepository {
    suspend fun getClientInfo(): Resource<ClientInfoVO>
}