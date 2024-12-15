package com.joelpigem.appprecafeteria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.joelpigem.appprecafeteria.databinding.FragmentPrimerPlatBinding
import com.joelpigem.appprecafeteria.databinding.FragmentTotalBinding

class PrimerPlatFragment : Fragment() {

    private val viewModel: ShareViewModel by activityViewModels()
    private lateinit var binding: FragmentPrimerPlatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrimerPlatBinding.inflate(inflater)

        binding.buttonArrow.setOnClickListener{
            var primerPlat = binding.editTextPrimerPlat.text.toString()
            var quantitat = binding.editTextQuantitat.text.toString()

            if (primerPlat.isEmpty() || quantitat.isEmpty()) {
                Toast.makeText(context, "Siusplou emplena tots els camps!", Toast.LENGTH_SHORT).show()
            }

            try {

                val quantitatNumero = quantitat.toInt()

                viewModel.afegirAlMenu(MenuModel(tipus = "primerPlat", nom = primerPlat, quantitat = quantitatNumero, preuUnitari = 10))

                findNavController().navigate(R.id.action_primerPlatFragment_to_begudaFragment, null)

            } catch (e: NumberFormatException) {

                Toast.makeText(context, "Escriu una quantitat correcte (números)!", Toast.LENGTH_SHORT).show()
            }


        }

        return binding.root
    }

}