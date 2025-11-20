package com.imobly.imobly.domains

import com.imobly.imobly.domains.enums.ReportStatusEnum
import com.imobly.imobly.domains.users.TenantDomain
import java.time.LocalDateTime

class ReportDomain(
    var id: String? = null,
    var title: String = "",
    var message: String = "",
    var moment: LocalDateTime = LocalDateTime.now(),
    var status: ReportStatusEnum = ReportStatusEnum.NEW,
    var response: String = "",
    var tenant: TenantDomain = TenantDomain(),
    var property: PropertyDomain = PropertyDomain()

): Comparable<ReportDomain> {

    override fun compareTo(other: ReportDomain): Int = -this.moment.compareTo(other.moment)
}