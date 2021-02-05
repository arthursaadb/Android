package com.saad.maximatechtest.client.business.model.vo

import com.squareup.moshi.Json

data class ContactVO(
    @field:Json(name = "nome") val name: String,
    @field:Json(name = "telefone") val phone: String,
    @field:Json(name = "celular") val cellPhone: String,
    @field:Json(name = "conjuge") val spouse: String,
    @field:Json(name = "tipo") val type: String,
    @field:Json(name = "time") val team: String,
    @field:Json(name = "e_mail") val email: String,
    @field:Json(name = "data_nascimento") val dateBirth: String,
    @field:Json(name = "dataNascimentoConjuge") val dateBirthSpouse: String
)