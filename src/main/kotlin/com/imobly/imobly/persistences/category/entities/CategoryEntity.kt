package com.imobly.imobly.persistences.category.entities

import com.imobly.imobly.persistences.property.entities.PropertyEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "tb_categoria")
class CategoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: String?,
    @Column(name = "titulo", nullable = false, length = 50)
    val title: String,
    @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL], orphanRemoval = true)
    val properties: List<PropertyEntity>
)