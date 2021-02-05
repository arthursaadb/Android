package com.saad.maximatechtest.client.business.datasource.remote

import com.saad.maximatechtest.client.business.model.vo.ClientVO
import retrofit2.Response
import retrofit2.http.GET

interface ClientService {
    @GET("cliente")
    suspend fun getClientInfo(): Response<ClientVO>
}