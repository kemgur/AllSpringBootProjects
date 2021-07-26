package com.example.folksdev.account.controller

import com.example.folksdev.account.dto.CustomerDto
import com.example.folksdev.account.service.CustomerService
import com.folksdev.account.dto.CustomerDto
import com.folksdev.account.service.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/customer")
class CustomerController(private val customerService: CustomerService) {
    @GetMapping("/{customerId}")
    fun getCustomerById(@PathVariable customerId: String?): ResponseEntity<CustomerDto> {
        return ResponseEntity.ok(customerService.getCustomerById(customerId!!))
    }

    @get:GetMapping
    val allCustomers: ResponseEntity<List<CustomerDto>>
        get() = ResponseEntity.ok(customerService.allCustomer)

}