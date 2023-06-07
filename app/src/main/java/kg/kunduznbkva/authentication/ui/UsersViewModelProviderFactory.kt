package kg.kunduznbkva.authentication.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kg.kunduznbkva.authentication.data.UserRepository

class UsersViewModelProviderFactory(private val usersRepository: UserRepository ): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return UsersViewModel(usersRepository) as T
    }
}