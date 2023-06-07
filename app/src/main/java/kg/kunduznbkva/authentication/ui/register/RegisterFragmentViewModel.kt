package kg.kunduznbkva.authentication.ui.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kg.kunduznbkva.authentication.data.UserRepository
import kg.kunduznbkva.authentication.data.model.UserEmail
import kotlinx.coroutines.launch
import okhttp3.Response


class RegisterFragmentViewModel(private val repository: UserRepository) : ViewModel() {
     val responseLiveEmailData = MutableLiveData<UserEmail?>()

    fun registerEmail(userEmail: UserEmail) = viewModelScope.launch{
        var response = repository.registerEmail(userEmail)
        responseLiveEmailData.value = response

    }
}