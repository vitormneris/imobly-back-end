package com.imobly.imobly.controllers.appointment.mappers

import com.imobly.imobly.controllers.appointment.dtos.AppointmentDTO
import com.imobly.imobly.controllers.category.dtos.CategoryDTO
import com.imobly.imobly.controllers.category.mappers.CategoryWebMapper
import com.imobly.imobly.controllers.property.dtos.PropertyDTO
import com.imobly.imobly.controllers.property.mappers.AddressWebMapper
import com.imobly.imobly.controllers.property.mappers.PropertyWebMapper
import com.imobly.imobly.domains.AppointmentDomain
import com.imobly.imobly.domains.CategoryDomain
import com.imobly.imobly.persistences.category.mappers.CategoryPersistenceMapper
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class AppointmentWebMapper() {
    fun toDomain(appointment: AppointmentDTO, mapper: PropertyWebMapper): AppointmentDomain =
        AppointmentDomain(
            appointment.id,
            appointment.guestName ?: "",
            appointment.moment ?: LocalDateTime.now(),
            appointment.guideName ?: "",
            appointment.telephone ?: "",
            mapper.toDomain(appointment.property ?: PropertyDTO(), CategoryWebMapper())
        )

    fun toDTO(appointment: AppointmentDomain, mapper: PropertyWebMapper): AppointmentDTO =
        AppointmentDTO(
            appointment.id,
            appointment.guestName,
            appointment.guideName,
            appointment.moment,
            appointment.telephone,
            mapper.toDTO(appointment.property, CategoryWebMapper())
        )

    fun toDTOs(categories: List<AppointmentDomain>): List<AppointmentDTO> =
        categories.map { toDTO(it, PropertyWebMapper(AddressWebMapper())) }
}