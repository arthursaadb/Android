package com.saad.maximatechtest.client.business.model.vo

import com.squareup.moshi.Json

data class ClientInfoVO(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "codigo") val code: String,
    @field:Json(name = "razao_social") val companyName: String,
    @field:Json(name = "nomeFantasia") val fantasyName: String,
    @field:Json(name = "cpf") val cpf: String?,
    @field:Json(name = "cnpj") val cnpj: String?,
    @field:Json(name = "ramo_atividade") val activityBranch: String?,
    @field:Json(name = "endereco") val address: String?,
    @field:Json(name = "status") val status: String,
    @field:Json(name = "contatos") val contacts: List<ContactVO>
)