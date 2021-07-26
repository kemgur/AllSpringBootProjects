package com.example.folksdev.account.dto.converter

import com.example.folksdev.account.dto.AccountCustomerDto
import com.example.folksdev.account.dto.CustomerAccountDto
import com.example.folksdev.account.dto.CustomerDto
import com.example.folksdev.account.model.Account
import com.example.folksdev.account.model.Customer
import com.folksdev.account.dto.AccountCustomerDto
import com.folksdev.account.dto.CustomerDto
import com.folksdev.account.model.Customer
import org.springframework.stereotype.Component
import java.util.*
import java.util.stream.Collectors


@Component
class CustomerDtoConverter(private val customerAccountDtoConverter: CustomerAccountDtoConverter) {
    fun convertToAccountCustomer(from: Optional<Customer>): AccountCustomerDto {
        return from.map { (id, name, surname) -> AccountCustomerDto(id, name, surname) }.orElse(null)
    }

    fun convertToCustomerDto(from: Customer): CustomerDto {
        return CustomerDto(
                from.id,
                from.name,
                from.surname,
                from.accounts
                        .stream()
                        .map { from: Account? -> customerAccountDtoConverter.convert(from!!) }
                        .collect(Collectors.toSet()))
    }
}