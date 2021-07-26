package com.example.folksdev.account.controller

import com.example.folksdev.account.dto.AccountDto
import com.example.folksdev.account.dto.CreateAccountRequest
import com.example.folksdev.account.service.AccountService
import com.folksdev.account.dto.AccountDto
import com.folksdev.account.dto.CreateAccountRequest
import com.folksdev.account.service.AccountService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid


@RestController
@RequestMapping("/v1/account")
class AccountController(private val accountService: AccountService) {
    @PostMapping
    fun createAccount(@RequestBody request: @Valid CreateAccountRequest?): ResponseEntity<AccountDto> {
        return ResponseEntity.ok(accountService.createAccount(request))
    }
}