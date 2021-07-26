package com.example.folksdev.account.repository

import com.example.folksdev.account.model.Transaction
import org.springframework.data.jpa.repository.JpaRepository


interface TransactionRepository : JpaRepository<Transaction?, String?>