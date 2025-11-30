package com.imobly.imobly.persistences.appointment.repositories

import com.imobly.imobly.persistences.appointment.entities.AppointmentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AppointmentRepository : JpaRepository<AppointmentEntity, String> {

    fun findByProperty_TitleContainingAllIgnoreCase(title: String): List<AppointmentEntity>
    fun deleteAllByProperty_Id(id: String)
}