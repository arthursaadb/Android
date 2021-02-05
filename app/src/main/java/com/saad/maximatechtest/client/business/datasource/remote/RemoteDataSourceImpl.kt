package com.saad.maximatechtest.client.business.datasource.remote

import com.saad.maximatechtest.client.business.model.vo.ClientVO
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val api: ClientService) : RemoteDataSource {
    override suspend fun getClientInfo(): Response<ClientVO> = api.getClientInfo()
}