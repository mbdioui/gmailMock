package com.example.data.remote

import com.example.data.dto.EmailListItemDto
import com.example.domain.model.EmailListItemModel

class EmailMapper {
    companion object {
        fun dtoToDomain(emailListItemDto: EmailListItemDto): EmailListItemModel {
            return EmailListItemModel(
                id=emailListItemDto.id,
                from= emailListItemDto.payload.email,
                profileImage = emailListItemDto.payload.profileImage,
                subject = emailListItemDto.subject,
                snippet = emailListItemDto.snippet,
                date= emailListItemDto.payload.date,
                isImportant = emailListItemDto.isImportant,
                isPromotional = emailListItemDto.isPromotional
            )
        }
    }
}
