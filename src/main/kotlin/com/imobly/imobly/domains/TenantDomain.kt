package com.imobly.imobly.domains

import com.imobly.imobly.domains.enums.MaritalStatusEnum
import java.time.LocalDate

class TenantDomain(
    id: String? = null,
    firstName: String,
    lastName: String,
    email: String,
    telephones: List<String>,
    password: String,
    address: AddressDomain,
    var rg: String,
    var cpf: String,
    var birthDate: LocalDate,
    var nationality: String,
    var maritalStatus: MaritalStatusEnum,
    var pathImage: String = ""
): RegisteredUserDomain(id, firstName, lastName, email, telephones, password, address)
