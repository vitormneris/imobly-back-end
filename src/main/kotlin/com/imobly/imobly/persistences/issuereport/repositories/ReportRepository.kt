package com.imobly.imobly.persistences.issuereport.repositories

import com.imobly.imobly.persistences.issuereport.entities.ReportEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ReportRepository: JpaRepository<ReportEntity, String>