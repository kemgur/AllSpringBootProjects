package com.example.folksdev.account.dto.converter

import com.example.folksdev.account.dto.TransactionDto
import com.folksdev.account.dto.TransactionDto
import com.folksdev.account.model.Transaction
import org.springframework.stereotype.Component


@Component
class TransactionDtoConverter {
    fun convert(from: Transaction): TransactionDto {
        return TransactionDto(from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate())
    }
}
