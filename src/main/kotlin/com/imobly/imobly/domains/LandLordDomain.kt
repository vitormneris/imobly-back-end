package com.imobly.imobly.domains

class LandLordDomain(
    id: String? = null,
    firstName: String,
    lastName: String,
    email: String,
    telephones: List<String>,
    password: String,
): RegisteredUserDomain(id, firstName, lastName, email, telephones, password)