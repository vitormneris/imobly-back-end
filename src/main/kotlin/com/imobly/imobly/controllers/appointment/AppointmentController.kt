package com.imobly.imobly.controllers.appointment

import com.imobly.imobly.controllers.appointment.dtos.AppointmentDTO
import com.imobly.imobly.controllers.appointment.mappers.AppointmentWebMapper
import com.imobly.imobly.controllers.property.mappers.AddressWebMapper
import com.imobly.imobly.controllers.property.mappers.PropertyWebMapper
import com.imobly.imobly.services.AppointmentService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/agendamentos")
class AppointmentController(
    val service: AppointmentService, val mapper: AppointmentWebMapper
) {
    @GetMapping("/encontrartodos")
    fun findAllByTitle(@RequestParam("titulo") title: String): ResponseEntity<List<AppointmentDTO>> =
        ResponseEntity.ok().body(
            mapper.toDTOs(service.findAllByPropertyTitle(title))
        )

    @PostMapping("/criar")
    fun insert(@Valid @RequestBody appointment: AppointmentDTO): ResponseEntity<AppointmentDTO> =
        ResponseEntity.status(HttpStatus.CREATED).body(
            mapper.toDTO(
                service.insert(mapper.toDomain(appointment, PropertyWebMapper(AddressWebMapper()))),
                PropertyWebMapper(AddressWebMapper())
            )
        )

    @DeleteMapping("/deletar/{id}")
    fun delete(@PathVariable id: String): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.ok().build()
    }
}