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
                val name = etName.text.toString()
                val cpf = etCPF.text.toString()
                val city = etCity.text.toString()
                val country = etCountry.text.toString()

                if(name.isNotEmpty() && cpf.isNotEmpty() && city.isNotEmpty() && country.isNotEmpty()) {
                    findNavController().navigate(
                        RegistrationFragmentDirections.actionRegistrationFragmentToRegistrationLoginFragment(name, cpf, city, country)
                    )
                } else {
                    tvError.visibility = View.VISIBLE
                }
            }
        }
    }

}