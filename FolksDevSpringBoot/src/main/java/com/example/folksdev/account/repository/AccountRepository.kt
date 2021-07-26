package com.example.folksdev.account.repository

import com.example.folksdev.account.model.Account
import org.springframework.data.jpa.repository.JpaRepository


interface AccountRepository : JpaRepository<Account?, String?>

