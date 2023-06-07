package kg.kunduznbkva.authentication.data

import RetrofitInstance
import kg.kunduznbkva.authentication.data.model.UserCreateRequest
import kg.kunduznbkva.authentication.data.model.UserEmail
import okhttp3.Response

class UserRepository {

    suspend fun registerUser(userCreateRequest: UserCreateRequest){
        RetrofitInstance.api.register(userCreateRequest)
    }

    suspend fun registerEmail(userEmail: UserEmail) : UserEmail? {
        val response = RetrofitInstance.api.registerEmail(userEmail)
        if (response.isSuccessful) {
            return response.body()
        } else {
            return null
        }
    }
}