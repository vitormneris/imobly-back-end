package com.imobly.imobly.persistences.issuereport.mappers

import com.imobly.imobly.domains.ReportDomain
import com.imobly.imobly.persistences.category.mappers.CategoryPersistenceMapper
import com.imobly.imobly.persistences.issuereport.entities.ReportEntity
import com.imobly.imobly.persistences.property.mappers.PropertyPersistenceMapper
import com.imobly.imobly.persistences.tenant.mappers.TenantPersistenceMapper
import org.springframework.stereotype.Component

@Component
class ReportPersistenceMapper(
    val tenantMapper: TenantPersistenceMapper,
    val propertyMapper: PropertyPersistenceMapper
) {

    fun toDomain(report: ReportEntity): ReportDomain =
        ReportDomain(
            report.id,
            report.title,
            report.message,
            report.moment,
            report.status,
            report.response,
            tenantMapper.toDomain(report.tenant),
            propertyMapper.toDomain(report.property, CategoryPersistenceMapper())
        )

    fun toDomains(reports: List<ReportEntity>): List<ReportDomain> =
        reports.map { toDomain(it) }

    fun toEntity(report: ReportDomain): ReportEntity =
        ReportEntity(
            report.id,
            report.title,
            report.message,
            report.moment,
            report.status,
            report.response,
            tenantMapper.toEntity(report.tenant),
            propertyMapper.toEntity(report.property, CategoryPersistenceMapper())
        )
}