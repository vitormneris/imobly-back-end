package com.imobly.imobly.persistences.issuereport.repositories

import com.imobly.imobly.persistences.issuereport.entities.ReportEntity
import org.springframework.context.annotation.Description
import org.springframework.data.jpa.repository.JpaRepository

interface ReportRepository : JpaRepository<ReportEntity, String> {
    fun findByTitleContainingOrMessageContainingOrProperty_TitleContainingOrTenant_FirstNameContainingOrTenant_LastNameContainingAllIgnoreCase(
        reportTitle: String,
        message: String,
        propertyTitle: String,
        firstName: String,
        lastName: String
    ): List<ReportEntity>

    fun findByTenant_IdAndTitleContainingIgnoreCaseOrTenant_IdAndMessageContainingIgnoreCaseOrTenant_IdAndProperty_TitleContainingIgnoreCase(
        id1: String,
        title: String,
        id2: String,
        message: String,
        id3: String,
        propertyTitle: String
    ): List<ReportEntity>

    fun deleteAllByProperty_Id(id: String)
}