package kg.kunduznbkva.authentication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kg.kunduznbkva.authentication.R
import kg.kunduznbkva.authentication.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openRegister()
    }

    private fun openRegister() {
        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_registerFragment)
        }
    }


}