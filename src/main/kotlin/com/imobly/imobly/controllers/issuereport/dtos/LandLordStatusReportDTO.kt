package com.imobly.imobly.controllers.issuereport.dtos

import com.imobly.imobly.domains.enums.ReportStatusEnum
import jakarta.validation.constraints.NotNull

data class LandLordStatusReportDTO(
    @field:NotNull(message = "O campo status é obrigatório")
    val status: ReportStatusEnum?
)