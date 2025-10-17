package com.imobly.imobly.controllers.tenant.dtos

import jakarta.validation.constraints.Pattern

data class TelephoneDTO(
    @field:Pattern(
        regexp = "^\\(\\d{2}\\)( )?(\\d{4}|\\d{5})-\\d{4}$",
        message = "Este telefone está inválido"
    )
    val telephone: String
)