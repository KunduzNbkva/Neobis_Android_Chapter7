package kg.kunduznbkva.authentication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.kunduznbkva.authentication.R
import kg.kunduznbkva.authentication.databinding.FragmentPasswordResetBinding


class PasswordResetFragment : Fragment() {
    private lateinit var binding: FragmentPasswordResetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPasswordResetBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

}