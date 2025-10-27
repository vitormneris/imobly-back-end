package com.imobly.imobly.controllers.issuereport.dtos

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class ResponseReportDTO(
    @field:NotNull(message = "O campo resposta é obrigatório")
    @field:Size(min = 10, max = 500, message = "O campo resposta deve ter entre 10  e 500 caracteres")
    val response: String?
)