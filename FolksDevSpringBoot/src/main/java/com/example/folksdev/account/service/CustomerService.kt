package com.example.folksdev.account.service

import com.example.folksdev.account.dto.CustomerDto
import com.example.folksdev.account.dto.converter.CustomerDtoConverter
import com.example.folksdev.account.exception.CustomerNotFoundException
import com.example.folksdev.account.model.Customer
import com.example.folksdev.account.repository.CustomerRepository
import com.folksdev.account.dto.CustomerDto
import com.folksdev.account.dto.converter.CustomerDtoConverter
import com.folksdev.account.exception.CustomerNotFoundException
import com.folksdev.account.model.Customer
import com.folksdev.account.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.util.function.Supplier
import java.util.stream.Collectors


@Service
class CustomerService(private val customerRepository: CustomerRepository,
                      converter: CustomerDtoConverter) {
    private val converter: CustomerDtoConverter
    protected fun findCustomerById(id: String): Customer {
        return (customerRepository.findById(id)
                .(orElseThrow<RuntimeException>(
                        Supplier<RuntimeException> { CustomerNotFoundException("Customer could not find by id: " + id) }))!!)
    }

    fun getCustomerById(customerId: String): CustomerDto {
        return converter.convertToCustomerDto(findCustomerById(customerId))
    }

    val allCustomer: List<Any>
        get() = customerRepository.findAll()
                .stream()
                .map<Any>(converter::convertToCustomerDto)
                .collect(Collectors.toList())

    init {
        this.converter = converter
    }
 }