package com.example.folksdev.account.repository

import com.example.folksdev.account.model.Customer
import com.folksdev.account.model.Customer
import org.springframework.data.jpa.repository.JpaRepository


interface CustomerRepository : JpaRepository<Customer?, String?>