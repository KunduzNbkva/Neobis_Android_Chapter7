package kg.kunduznbkva.authentication.data.remote

import kg.kunduznbkva.authentication.data.model.UserCreateRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("register/")
    fun register(@Body request: UserCreateRequest): UserCreateRequest

}