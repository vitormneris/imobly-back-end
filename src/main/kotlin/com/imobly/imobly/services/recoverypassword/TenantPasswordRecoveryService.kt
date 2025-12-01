package com.imobly.imobly.services.recoverypassword

import com.imobly.imobly.domains.recoverypassword.RecoveryPasswordTenantDomain
import com.imobly.imobly.exceptions.OperationNotAllowedException
import com.imobly.imobly.exceptions.ResourceNotFoundException
import com.imobly.imobly.exceptions.enums.RuntimeErrorEnum
import com.imobly.imobly.persistences.recoverypassword.mappers.RecoveryPasswordPersistenceMapper
import com.imobly.imobly.persistences.recoverypassword.repositories.RecoveryPasswordTenantRepository
import com.imobly.imobly.persistences.tenant.mappers.TenantPersistenceMapper
import com.imobly.imobly.persistences.tenant.repositories.TenantRepository
import com.imobly.imobly.services.EmailService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TenantPasswordRecoveryService (
    private val tenantRepository: TenantRepository,
    private val tenantMapper: TenantPersistenceMapper,
    private val recoveryPasswordRepository: RecoveryPasswordTenantRepository,
    private val recoveryPasswordMapper: RecoveryPasswordPersistenceMapper,
    private val emailService: EmailService
) {
    fun getCode(email: String) {
        val token =  String.format("%06d", (0..999999).random())
        recoveryPasswordRepository.findByTenant_Email(email).ifPresentOrElse(
            {
                val recoveryPassword = recoveryPasswordMapper.toDomain(it)
                recoveryPassword.token = token
                recoveryPassword.moment = LocalDateTime.now().plusMinutes(5)
                recoveryPasswordRepository.save(recoveryPasswordMapper.toEntity(recoveryPassword))
            },
            {
                val tenant = tenantRepository.findByEmail(email).orElse(null)
                if (tenant != null) {
                    val recoveryPassword = RecoveryPasswordTenantDomain(
                        token = token,
                        tenant = tenantMapper.toDomain(tenant),
                        moment = LocalDateTime.now().plusMinutes(5)
                    )
                    recoveryPasswordRepository.save(recoveryPasswordMapper.toEntity(recoveryPassword))
                }
            }
        )
        emailService.sendEmail(email, "Recuperar Senha", "Código de confirmação: $token")
    }

    fun changePassword(email: String, token: String, newPassword: String) {

        if ( !validateToken(email, token) ) {
            throw OperationNotAllowedException(RuntimeErrorEnum.ERR0021)
        }

        val tenant = tenantMapper.toDomain(tenantRepository.findByEmail(email).orElseThrow {
            throw ResourceNotFoundException(RuntimeErrorEnum.ERR0020)
        })
        tenant.passwd = BCryptPasswordEncoder().encode(newPassword)
        tenantRepository.save(tenantMapper.toEntity(tenant))

        val recoveryPassword = recoveryPasswordRepository.findByTenant_Email(email).orElseThrow {
            throw ResourceNotFoundException(RuntimeErrorEnum.ERR0020)
        }
        recoveryPasswordRepository.delete(recoveryPassword)
    }

    fun validateToken(email: String, token: String): Boolean {
        val recoveryPassword = recoveryPasswordRepository.findByTenant_Email(email).orElse(null) ?: return false

        if (recoveryPassword.moment.isBefore(LocalDateTime.now())) {
            recoveryPasswordRepository.delete(recoveryPassword)
            return false
        }

        val result = recoveryPassword.token == token
        if (!result) {
            recoveryPasswordRepository.delete(recoveryPassword)
        }
        return result
    }
}