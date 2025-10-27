package com.imobly.imobly.persistences.landlord.repositories

import com.imobly.imobly.persistences.landlord.entities.LandLordEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LandLordRepository: JpaRepository<LandLordEntity, String>