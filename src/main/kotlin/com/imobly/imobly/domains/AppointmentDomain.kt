package com.imobly.imobly.domains

import java.time.LocalDate
import java.time.LocalDateTime

class AppointmentDomain(
    var id: String? = null,
    var guestName: String,
    var moment: LocalDate,
    var telephone: String,
    var property: PropertyDomain
) : Comparable<AppointmentDomain> {
    override fun compareTo(other: AppointmentDomain): Int =
        other.property.title.compareTo(this.property.title)
}