package br.com.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.login.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listener()
    }

    private fun listener(){
        binding.btnLogin.setOnClickListener{
            findNavController().navigate(
                MenuFragmentDirections.actionMenuFragmentToLoginFragment()
            )
        }

        binding.btnSingUp.setOnClickListener{
            findNavController().navigate(
                MenuFragmentDirections.actionMenuFragmentToRegistrationFragment()
            )
        }
    }
}