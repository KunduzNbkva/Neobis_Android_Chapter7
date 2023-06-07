package kg.kunduznbkva.authentication.data

import RetrofitInstance
import kg.kunduznbkva.authentication.data.model.UserCreateRequest

class UserRepository {

    suspend fun registerUser(userCreateRequest: UserCreateRequest){
        RetrofitInstance.api.register(userCreateRequest)
    }
}