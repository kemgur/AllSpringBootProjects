package com.example.folksdev.account.dto.converter

import com.example.folksdev.account.dto.AccountDto
import com.example.folksdev.account.model.Account
import com.folksdev.account.dto.AccountDto
import com.folksdev.account.model.Account
import org.springframework.stereotype.Component
import java.util.*
import java.util.stream.Collectors


@Component
class AccountDtoConverter(customerDtoConverter: CustomerDtoConverter,
                          transactionDtoConverter: TransactionDtoConverter) {
    private val customerDtoConverter: CustomerDtoConverter
    private val transactionDtoConverter: TransactionDtoConverter
    fun convert(from: Account): AccountDto {
        return AccountDto(from.id,
                from.balance,
                from.creationDate,
                customerDtoConverter.convertToAccountCustomer(Optional.ofNullable(from.customer)),
                Objects.requireNonNull<Set<error.NonExistentClass>>(from.transaction)
                        .stream()
                        .map<Any>(transactionDtoConverter::convert)
                        .collect(Collectors.toSet()))
    }

    init {
        this.customerDtoConverter = customerDtoConverter
        this.transactionDtoConverter = transactionDtoConverter
    }
}