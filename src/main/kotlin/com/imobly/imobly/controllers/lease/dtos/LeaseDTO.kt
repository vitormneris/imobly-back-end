package com.imobly.imobly.controllers.lease.dtos

import com.fasterxml.jackson.annotation.JsonFormat
import com.imobly.imobly.controllers.property.dtos.PropertyDTO
import com.imobly.imobly.controllers.tenant.dtos.TenantDTO
import java.time.LocalDate
import java.time.LocalDateTime

data class LeaseDTO(
    val id: String? = null,

    @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    val startDate: LocalDate? = LocalDate.of(2000, 1, 1),

    @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    val endDate: LocalDate? = LocalDate.of(2000, 1, 1),

    @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    val createdAt: LocalDateTime? = LocalDateTime.of(2000, 1, 1, 0, 0),

    @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    val lastUpdatedAt: LocalDateTime? = LocalDateTime.of(2000, 1, 1, 0, 0),

    val property: PropertyDTO? = PropertyDTO(),

    val tenant: TenantDTO? = TenantDTO(),

    val durationInMonths: Long? = 0,

    val monthlyRent: Double? = 0.0,

    val securityDeposit: Double? = 0.0,

    val paymentDueDay: Int? = 0,

    val isEnabled: Boolean? = false
)