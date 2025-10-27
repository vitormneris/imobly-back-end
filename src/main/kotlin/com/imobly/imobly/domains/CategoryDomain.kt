package com.imobly.imobly.domains

class CategoryDomain(
    var id: String? = null,
    var title: String,
    val properties: List<PropertyDomain>
)