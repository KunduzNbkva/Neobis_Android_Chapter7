package kg.kunduznbkva.authentication.ui.register

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kg.kunduznbkva.authentication.R
import kg.kunduznbkva.authentication.databinding.FragmentRegisterBinding
import java.util.*

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkInputEmail()
        backBtn()
    }

    private fun backBtn() {
        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_mainFragment)
        }
    }

    private fun checkInputEmail() {
        binding.etEmail.addTextChangedListener(inputTxtWatcher)
    }

    private val inputTxtWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val emailInput = binding.etEmail.text.toString().trim()
            val button = binding.nextBtn

            if (!emailInput.contains("@")) {
                button.isEnabled = true
                button.setBackgroundResource(R.drawable.btn_bg)
            } else {
                button.isEnabled = false
                button.setBackgroundResource(R.drawable.fields_back)
            }
        }

        override fun afterTextChanged(s: Editable?) {
        }
    }


}