package kg.kunduznbkva.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kg.kunduznbkva.authentication.data.UserRepository
import kg.kunduznbkva.authentication.databinding.ActivityMainBinding
import kg.kunduznbkva.authentication.ui.UsersViewModel
import kg.kunduznbkva.authentication.ui.UsersViewModelProviderFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    lateinit var viewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        val repository = UserRepository()
        val viewModelProviderFactory = UsersViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory!!)[UsersViewModel::class.java]
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}