package com.example.folksdev.account.dto.converter

import com.example.folksdev.account.dto.CustomerAccountDto
import com.example.folksdev.account.model.Account
import com.folksdev.account.dto.CustomerAccountDto
import com.folksdev.account.model.Account
import org.springframework.stereotype.Component
import java.util.*
import java.util.stream.Collectors


@Component
class CustomerAccountDtoConverter(converter: TransactionDtoConverter) {
    private val transactionDtoConverter: TransactionDtoConverter
    fun convert(from: Account): CustomerAccountDto {
        return CustomerAccountDto(
                Objects.requireNonNull(from.id),
                from.balance,
                from.transaction
                        .stream()
                        .map<Any>(transactionDtoConverter::convert)
                        .collect(Collectors.toSet()),
                from.creationDate)
    }

    init {
        transactionDtoConverter = converter
    }
}