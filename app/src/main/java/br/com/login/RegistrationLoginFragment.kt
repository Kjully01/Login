package br.com.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.login.databinding.FragmentRegistrationLoginBinding

class RegistrationLoginFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationLoginBinding

    private val args: RegistrationLoginFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener()
    }

    private fun listener() {
        binding.run {
            btnRegistration.setOnClickListener {
                val email = etEmail.text.toString()
                val password = etPassword.text.toString()

                if (email.isNotEmpty() && password.isNotEmpty()) {
                    findNavController().navigate(
                        RegistrationLoginFragmentDirections.actionRegistrationLoginFragmentToConfirmationFragment(
                            args.name,
                            args.cpf,
                            args.city,
                            args.country,
                            email,
                            password
                        )
                    )
                } else {
                    tvError.visibility = View.VISIBLE
                }
            }
        }
    }

}