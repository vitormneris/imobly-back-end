package com.imobly.imobly.services

import com.imobly.imobly.domains.AppointmentDomain
import com.imobly.imobly.exceptions.ResourceNotFoundException
import com.imobly.imobly.exceptions.enums.RuntimeErrorEnum
import com.imobly.imobly.persistences.appointment.mappers.AppointmentPersistenceMapper
import com.imobly.imobly.persistences.appointment.repositories.AppointmentRepository
import com.imobly.imobly.persistences.property.mappers.AddressPersistenceMapper
import com.imobly.imobly.persistences.property.mappers.PropertyPersistenceMapper
import org.springframework.stereotype.Service
import java.util.Collections

@Service
class AppointmentService(
    private val repository: AppointmentRepository, private val mapper: AppointmentPersistenceMapper
) {
    fun findAllByPropertyTitle(title: String): List<AppointmentDomain> {
        val list = mapper.toDomains(repository.findByProperty_TitleContainingAllIgnoreCase(title))
        Collections.sort(list)
        return list
    }

    fun insert(appointment: AppointmentDomain): AppointmentDomain {
        val appointmentSaved = repository.save(
            mapper.toEntity(appointment, PropertyPersistenceMapper(AddressPersistenceMapper()))
        )
        return mapper.toDomain(appointmentSaved, PropertyPersistenceMapper(AddressPersistenceMapper()))
    }

    fun delete(id: String) {
        if (!repository.existsById(id)) {
            throw ResourceNotFoundException(RuntimeErrorEnum.ERR0030)
        }
        repository.deleteById(id)
    }
}