package com.saad.maximatechtest.client.business.model.vo

import com.squareup.moshi.Json

data class ClientVO(
    @field:Json(name = "cliente") val client: ClientInfoVO
)
