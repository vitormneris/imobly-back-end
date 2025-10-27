package com.imobly.imobly.controllers.category.dtos

import com.imobly.imobly.controllers.property.dtos.PropertyDTO
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CategoryDTO(
    val id: String? = null,

    @field:NotNull(message = "O campo título é obrigatório")
    @field:Size(min = 3, max = 50, message = "O campo título deve ter entre 3  e 50 caracteres")
    val title: String? = "",

    val properties: List<PropertyDTO>? = emptyList()
)