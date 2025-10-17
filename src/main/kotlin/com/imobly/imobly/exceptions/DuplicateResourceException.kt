package com.imobly.imobly.exceptions

import com.imobly.imobly.exceptions.enums.RuntimeErrorEnum

class DuplicateResourceException(val errorEnum: RuntimeErrorEnum): RuntimeException()