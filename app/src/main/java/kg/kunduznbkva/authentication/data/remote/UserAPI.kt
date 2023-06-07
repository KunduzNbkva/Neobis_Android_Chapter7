package kg.kunduznbkva.authentication.data.remote

import kg.kunduznbkva.authentication.data.model.UserCreateRequest
import kg.kunduznbkva.authentication.data.model.UserEmail
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("register/")
    fun register(@Body request: UserCreateRequest): UserCreateRequest

    @POST("register/email/")
    fun registerEmail(@Body request: UserEmail): UserCreateRequest

}