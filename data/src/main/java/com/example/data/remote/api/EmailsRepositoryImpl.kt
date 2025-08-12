package com.example.data.remote


import com.example.core.ApiResponse
import com.example.core.ErrorResponse
import com.example.data.dto.EmailDetailDto
import com.example.data.dto.EmailListItemDto
import com.example.data.dto.Payload
import com.example.data.remote.api.ApiService
import com.example.domain.model.EmailDetailsModel
import com.example.domain.model.EmailListItemModel
import com.example.domain.repository.EmailRepository
import kotlinx.coroutines.runBlocking
import retrofit2.Response

class EmailsRepositoryImpl(private val apiService: ApiService) : EmailRepository {
    override suspend fun getEmails(): ApiResponse<List<EmailListItemModel>> {
        val result: Response<List<EmailListItemDto>> = apiService.getEmails()
        when {
            (result.isSuccessful && result.body() != null) -> {
                val emailListMapped = result.body()?.map { emailListItemDto ->
                    EmailMapper.dtoToDomain(emailListItemDto)
                }
                emailListMapped?.let { mappedList -> return ApiResponse.Success(mappedList) }
                return ApiResponse.Error(ErrorResponse.UnknownError(Throwable()))

            }

            (result.body() == null && result.code() != 0) -> {
                return ApiResponse.Error(
                    ErrorResponse.ServorError(
                        code = result.code(),
                        message = result.message()
                    )
                )
            }

        }
        return ApiResponse.Error(ErrorResponse.UnknownError(Throwable()))
    }

    override suspend fun getEmailDetails(): ApiResponse<List<EmailDetailsModel>> {
        return ApiResponse.Error(ErrorResponse.UnknownError(Throwable()))
    }
}


fun main() =
    runBlocking {
        val apiService = MockApiService()
        val emailRepository = EmailsRepositoryImpl(apiService)


        val emailList = emailRepository.getEmails()
        val emailListDetails = emailRepository.getEmailDetails()

        println("list of result $emailList")
        println("list of details list $emailListDetails")


    }


class MockApiService : ApiService {
    override suspend fun getEmails(): Response<List<EmailListItemDto>> {
        val mockEmailList = arrayListOf<EmailListItemDto>(
            EmailListItemDto(
                hasAttachments = false,
                id = "1",
                isImportant = true,
                isPromotional = false,
                payload = Payload(
                    "",
                    "",
                    "",
                    "",
                    ""
                ),
                snippet = "mock snippet",
                subject = "fake subject",
                threadId = "tread1",
                timestamp = System.currentTimeMillis().toString()
            )
        )
        return Response.success(mockEmailList)
    }

    override suspend fun getEmailDetails(): Response<List<EmailDetailDto>> {
        return Response.error(404, null)
    }
}