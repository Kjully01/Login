package br.com.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.login.databinding.FragmentConfirmationBinding

class ConfirmationFragment : Fragment() {

    private lateinit var binding : FragmentConfirmationBinding

    private val args: ConfirmationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConfirmationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addData()
        listener()
    }

    private fun addData(){
        binding.apply {
            confirmItem.tvInfoName.text = args.name
            confirmItem.tvInfoCPF.text = args.cpf
            confirmItem.tvInfoCity.text = args.city
            confirmItem.tvInfoCountry.text = args.country
            confirmItem.tvInfoEmail.text = args.email
            confirmItem.tvInfoPassword.text = args.password
        }
    }

    private fun listener(){
        binding.btnConfirm.setOnClickListener{
            findNavController().navigate(
                ConfirmationFragmentDirections.actionConfirmationFragmentToHomeFragment2()
            )
        }

        binding.btnCancel.setOnClickListener {
            findNavController().navigate(
                ConfirmationFragmentDirections.actionConfirmationFragmentToMenuFragment()
            )
        }
    }

}