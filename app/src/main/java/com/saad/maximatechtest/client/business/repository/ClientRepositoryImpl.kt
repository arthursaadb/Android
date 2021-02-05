package com.saad.maximatechtest.client.business.repository

import com.saad.maximatechtest.client.business.datasource.local.LocalDataSource
import com.saad.maximatechtest.client.business.datasource.remote.RemoteDataSource
import com.saad.maximatechtest.client.business.model.vo.ClientInfoVO
import com.saad.maximatechtest.utils.Resource
import com.saad.maximatechtest.utils.Status
import javax.inject.Inject

class ClientRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : ClientRepository {
    override suspend fun getClientInfo(): Resource<ClientInfoVO> {
        remoteDataSource.getClientInfo().let {
            return if (it.isSuccessful) {
                Resource(Status.SUCCESS, it.body()?.client)
            } else {
                Resource(Status.ERROR, null)
            }
        }
    }
}