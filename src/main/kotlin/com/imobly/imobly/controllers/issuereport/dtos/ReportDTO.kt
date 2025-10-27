package com.imobly.imobly.controllers.issuereport.dtos

import com.fasterxml.jackson.annotation.JsonFormat
import com.imobly.imobly.controllers.tenant.dtos.TenantDTO
import com.imobly.imobly.domains.enums.ReportStatusEnum
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDate
import java.time.LocalDateTime

data class ReportDTO(
    val id: String?,

    @field:NotNull(message = "O campo título é obrigatório")
    @field:Size(min = 3, max = 40, message = "O campo título deve ter entre 3  e 50 caracteres")
    val title: String?,

    @field:NotNull(message = "O campo mensagem é obrigatório")
    @field:Size(min = 10, max = 500, message = "O campo mensagem deve ter entre 10  e 500 caracteres")
    val message: String?,

    @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    val moment: LocalDateTime?,

    val status: ReportStatusEnum?,

    @field:NotNull(message = "O campo resposta é obrigatório")
    @field:Size(min = 10, max = 500, message = "O campo resposta deve ter entre 10  e 500 caracteres")
    val response: String?,

    @field:NotNull(message = "O ID do locatário é obrigatório")
    val tenant: TenantDTO?
)