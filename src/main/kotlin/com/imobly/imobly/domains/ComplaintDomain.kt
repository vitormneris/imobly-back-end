package com.imobly.imobly.domains

class ComplaintDomain(
    var id: String? = null,
    var title: String,
    var message: String,
    var tenantId: String
)