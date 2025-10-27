package com.imobly.imobly.controllers.lease.dtos

import com.imobly.imobly.controllers.property.dtos.PropertyDTO
import com.imobly.imobly.controllers.tenant.dtos.TenantDTO
import java.time.LocalDate
import java.time.LocalDateTime

data class LeaseDTO(
    val id: String?,

    val startDate: LocalDate?,

    val endDate: LocalDate?,

    val createdAt: LocalDateTime?,

    val lastUpdatedAt: LocalDateTime?,

    val property: PropertyDTO?,

    val tenant: TenantDTO?,

    val durationInMonths: Long?,

    val monthlyRent: Double?,

    val securityDeposit: Double?,

    val paymentDueDay: Int?
)