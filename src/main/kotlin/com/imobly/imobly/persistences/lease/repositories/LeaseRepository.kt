package com.imobly.imobly.persistences.lease.repositories

import com.imobly.imobly.persistences.lease.entities.LeaseEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LeaseRepository: JpaRepository<LeaseEntity, String>