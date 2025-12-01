package com.imobly.imobly.persistences.appointment.mappers

import com.imobly.imobly.domains.AppointmentDomain
import com.imobly.imobly.persistences.appointment.entities.AppointmentEntity
import com.imobly.imobly.persistences.category.mappers.CategoryPersistenceMapper
import com.imobly.imobly.persistences.property.mappers.AddressPersistenceMapper
import com.imobly.imobly.persistences.property.mappers.PropertyPersistenceMapper
import org.springframework.stereotype.Component

@Component
class AppointmentPersistenceMapper {

    fun toDomains(appointments: List<AppointmentEntity>): List<AppointmentDomain> =
        appointments.map { toDomain(it, PropertyPersistenceMapper(AddressPersistenceMapper())) }

    fun toEntity(appointment: AppointmentDomain, mapper: PropertyPersistenceMapper): AppointmentEntity =
        AppointmentEntity(
            appointment.id,
            appointment.guestName,
            appointment.moment,
            appointment.telephone,
            mapper.toEntity(appointment.property, CategoryPersistenceMapper())
        )

    fun toDomain(appointment: AppointmentEntity, mapper: PropertyPersistenceMapper): AppointmentDomain =
        AppointmentDomain(
            appointment.id,
            appointment.guestName,
            appointment.moment,
            appointment.telephone,
            mapper.toDomain(appointment.property, CategoryPersistenceMapper())
        )
}
