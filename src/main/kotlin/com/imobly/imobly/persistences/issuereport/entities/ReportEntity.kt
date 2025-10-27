package com.imobly.imobly.persistences.issuereport.entities

import com.imobly.imobly.domains.enums.ReportStatusEnum
import com.imobly.imobly.persistences.tenant.entities.TenantEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "tb_reportacao")
class ReportEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    @Column(name = "titulo", nullable = false, length = 40)
    val title: String,
    @Column(name = "mensagem", nullable = false, length = 500)
    val message: String,
    @Column(name = "momento", nullable = false)
    val moment: LocalDateTime,
    @Column(nullable = false)
    val status: ReportStatusEnum,
    @Column(name = "resposta", nullable = false, length = 500)
    val response: String,
    @ManyToOne
    @JoinColumn(name = "fk_locatario_id", referencedColumnName = "id")
    val tenant: TenantEntity
)