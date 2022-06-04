package br.com.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.login.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener()
    }

    private fun listener(){
        binding.run {
            btnContinue.setOnClickListener{
                val name = etName.text.toString().isNotEmpty()
                val cpf = etCPF.text.toString().isNotEmpty()
                val city = etCity.text.toString().isNotEmpty()
                val country = etCountry.text.toString().isNotEmpty()

                if(name && cpf && city && country) {
                    findNavController().navigate(
                        RegistrationFragmentDirections.actionRegistrationFragmentToRegistrationLoginFragment()
                    )
                } else {
                    tvError.visibility = View.VISIBLE
                }
            }
        }
    }

}