package com.saad.maximatechtest.client.business.datasource.remote

import com.saad.maximatechtest.client.business.model.vo.ClientVO
import retrofit2.Response

interface RemoteDataSource {
    suspend fun getClientInfo(): Response<ClientVO>
}