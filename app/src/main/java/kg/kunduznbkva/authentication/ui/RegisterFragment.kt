package kg.kunduznbkva.authentication.ui

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.res.ColorStateList
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kg.kunduznbkva.authentication.MainActivity
import kg.kunduznbkva.authentication.R
import kg.kunduznbkva.authentication.data.model.UserEmail
import kg.kunduznbkva.authentication.databinding.DialogPasswordResetBinding
import kg.kunduznbkva.authentication.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: UsersViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        checkInputEmail()
        registerEmail()
        checkResponse()
        backBtn()

    }

    @SuppressLint("ResourceAsColor")
    private fun checkResponse() {
        viewModel.responseLiveEmailData.observe(viewLifecycleOwner) { response ->
            if (response != null) {
                showDialog()
            } else {
                binding.etEmailLayout.boxStrokeColor = R.color.red_error
                binding.etEmailLayout.defaultHintTextColor = ColorStateList.valueOf(R.color.red_error)
                binding.etEmailLayout.error ="Неправильно ввели данные, попробуйте еще раз"
            }
        }
    }

    private fun showDialog() {
        val dialog = Dialog(requireContext())
        val dialogBinding = DialogPasswordResetBinding.inflate(layoutInflater)
        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setView(dialogBinding.root)
        dialog.setCancelable(false)
        dialog.window?.attributes!!.windowAnimations = R.style.animation
        dialogBuilder
            .setPositiveButton(getText(R.string.close)) { dialog, which ->
               Toast.makeText(requireContext(),"Закрыто", Toast.LENGTH_SHORT)
            }
    }

    private fun registerEmail() {
        val email = binding.etEmail.text.toString()
        viewModel.registerEmail(UserEmail(email))
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