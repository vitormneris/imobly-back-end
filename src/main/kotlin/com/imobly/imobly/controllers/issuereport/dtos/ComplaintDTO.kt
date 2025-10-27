package com.imobly.imobly.controllers.issuereport.dtos

import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class ComplaintDTO(
    val id: String?,

    @field:NotNull(message = "O campo título é obrigatório")
    @field:Size(min = 3, max = 40, message = "O campo título deve ter entre 3  e 50 caracteres")
    val title: String?,

    @field:NotNull(message = "O campo mensagem é obrigatório")
    @field:Size(min = 10, max = 500, message = "O campo mensagem deve ter entre 10  e 500 caracteres")
    val message: String?,

    @field:NotNull(message = "O ID do locatário é obrigatório")
    val tenantId: String?
)