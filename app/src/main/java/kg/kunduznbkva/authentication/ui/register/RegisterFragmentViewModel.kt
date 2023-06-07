package kg.kunduznbkva.authentication.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.kunduznbkva.authentication.data.UserRepository
import kg.kunduznbkva.authentication.data.model.UserCreateRequest
import kotlinx.coroutines.launch

class RegisterFragmentViewModel(private val repository: UserRepository) : ViewModel() {

    fun registerUser(userCreateRequest: UserCreateRequest) = viewModelScope.launch{
        repository.registerUser(userCreateRequest)
    }
}