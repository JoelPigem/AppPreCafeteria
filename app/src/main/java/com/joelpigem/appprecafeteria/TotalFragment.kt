package com.joelpigem.appprecafeteria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.joelpigem.appprecafeteria.databinding.FragmentTotalBinding


class TotalFragment : Fragment() {

    private val viewModel: ShareViewModel by activityViewModels()
    private lateinit var binding: FragmentTotalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTotalBinding.inflate(inflater)

        viewModel.calcularPreuTotal()


        /*val textPrimerPlat = viewModel.primerPlat.quantitat.toString() + " " + viewModel.primerPlat.nom + " " + viewModel.preuTotalPrimerPlat.toString() + "€"
        val textBeguda = viewModel.beguda.quantitat.toString() + " " + viewModel.beguda.nom + " " + viewModel.preuTotalBeguda.toString() + "€"
        val textTotal = viewModel.preuTotal.toString() + "€"

        binding.textViewPreuPrimerPlat.text = textPrimerPlat
        binding.textViewPreuBeguda.text = textBeguda
        binding.textViewPreuTotal.text = textTotal*/


         viewModel.primerPlat.observe(viewLifecycleOwner) { primerPlat ->
            val textPrimerPlat = primerPlat.quantitat.toString() + " " +  primerPlat.nom + " " + viewModel.preuTotalPrimerPlat.value.toString() + "€"
            binding.textViewPreuPrimerPlat.text = textPrimerPlat
        }

        viewModel.beguda.observe(viewLifecycleOwner) { beguda ->
            val textBeguda = beguda.quantitat.toString() + " " + beguda.nom + " " + viewModel.preuTotalBeguda.value.toString() + "€"
            binding.textViewPreuBeguda.text = textBeguda
        }

        viewModel.preuTotal.observe(viewLifecycleOwner) { preuTotal ->
            binding.textViewPreuTotal.text = preuTotal.toString() + "€"
        }

        return binding.root
    }

}