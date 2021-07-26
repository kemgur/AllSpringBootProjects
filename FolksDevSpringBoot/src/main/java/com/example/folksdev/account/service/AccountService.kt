package com.example.folksdev.account.service

import com.example.folksdev.account.model.Account
import com.example.folksdev.account.model.Customer
import com.example.folksdev.account.repository.AccountRepository
import com.folksdev.account.dto.AccountDto
import com.folksdev.account.dto.converter.AccountDtoConverter
import com.folksdev.account.dto.CreateAccountRequest
import com.folksdev.account.model.Account
import com.folksdev.account.model.Customer
import com.folksdev.account.model.Transaction
import com.folksdev.account.repository.AccountRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.Clock
import java.time.Instant
import java.time.LocalDateTime


@Service
class AccountService(private val accountRepository: AccountRepository,
                     customerService: CustomerService,
                     converter: AccountDtoConverter, clock: Clock) {
    private val customerService: CustomerService
    private val converter: AccountDtoConverter
    private val clock: Clock
    fun createAccount(createAccountRequest: CreateAccountRequest): AccountDto {
        val customer: Customer = customerService.findCustomerById(createAccountRequest.getCustomerId())
        val account = Account(
                customer,
                createAccountRequest.getInitialCredit(),
                localDateTimeNow)
        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            val transaction = Transaction(
                    createAccountRequest.getInitialCredit(),
                    localDateTimeNow,
                    account)
            account.transaction.add(transaction)
        }
        return converter.convert(accountRepository.save(account))
    }

    private val localDateTimeNow: LocalDateTime
        private get() {
            val instant = clock.instant()
            return LocalDateTime.ofInstant(
                    instant,
                    Clock.systemDefaultZone().zone)
        }

    init {
        this.customerService = customerService
        this.converter = converter
        this.clock = clock
    }
}