package com.imobly.imobly.controllers.category.mappers

import com.imobly.imobly.controllers.category.dtos.CategoryDTO
import com.imobly.imobly.controllers.property.mappers.AddressWebMapper
import com.imobly.imobly.controllers.property.mappers.PropertyWebMapper
import com.imobly.imobly.domains.CategoryDomain
import org.springframework.stereotype.Component

@Component
class CategoryWebMapper() {
    fun toDomain(category: CategoryDTO): CategoryDomain =
        CategoryDomain(title = category.title ?: "", properties = emptyList())

    fun toDomainOnlyId(category: CategoryDTO): CategoryDomain =
        CategoryDomain(category.id, "", emptyList())

    fun toDTO(category: CategoryDomain, propertyMapper: PropertyWebMapper): CategoryDTO =
        CategoryDTO(category.id, category.title, propertyMapper.toDTOs(category.properties))

    fun toDTOs(categories: List<CategoryDomain>): List<CategoryDTO> =
        categories.map { toDTO(it, PropertyWebMapper(AddressWebMapper())) }
}