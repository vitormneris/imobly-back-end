package com.imobly.imobly.controllers.appointment.dtos

import com.fasterxml.jackson.annotation.JsonFormat
import com.imobly.imobly.controllers.property.dtos.PropertyDTO
import jakarta.validation.constraints.FutureOrPresent
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.time.LocalDateTime

data class AppointmentDTO(
    val id: String?,

    val guideName: String?,

    @field:NotNull(message = "O campo nome é obrigatório")
    @field:Size(min = 3, max = 50, message = "O campo nome deve ter entre 3  e 50 caracteres")
    val guestName: String?,

    @field:NotNull(message = "O campo data e horário é obrigatório")
    @field:FutureOrPresent(message = "O campo data e horário deve estar no presente ou futuro")
    @field:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    val moment: LocalDateTime?,

    @field:NotNull(message = "O campo telefone é obrigatório")
    @field:Size(min = 3, max = 50, message = "O campo telefone deve ter entre 3  e 50 caracteres")
    val telephone: String?,

    @field:NotNull(message = "O campo propriedade é obrigatório")
    val property: PropertyDTO?
)