package br.com.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.login.databinding.FragmentRegistrationLoginBinding

class RegistrationLoginFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationLoginBinding

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

    private fun listener(){
        binding.run {
            btnRegistration.setOnClickListener {
                if (etEmail.text.toString().isNotEmpty() && etPassword.text.toString()
                        .isNotEmpty()
                ) {
                    findNavController().navigate(
                        RegistrationLoginFragmentDirections.actionRegistrationLoginFragmentToConfirmationFragment()
                    )
                } else {
                    tvError.visibility = View.VISIBLE
                }
            }
        }
    }

}