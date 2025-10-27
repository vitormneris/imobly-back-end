package com.imobly.imobly.domains

import com.imobly.imobly.domains.enums.ReportStatusEnum

class StatusReportDomain(
    var status: ReportStatusEnum = ReportStatusEnum.PENDING
)