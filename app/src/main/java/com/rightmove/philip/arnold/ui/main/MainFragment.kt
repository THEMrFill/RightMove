package com.rightmove.philip.arnold.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.rightmove.philip.arnold.R
import com.rightmove.philip.arnold.databinding.MainFragmentBinding
import com.rightmove.philip.arnold.utils.NumberFormatter.formatNumber
import com.rightmove.philip.arnold.utils.nonNullObserve
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.main_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupObservables()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)
    }

    private fun setupObservables() {
        with (viewModel) {
            listOfProperties.nonNullObserve(viewLifecycleOwner) { properties ->
                val averagePrice = properties.properties.map { it.price }.average()
                with (binding.average) {
                    setTextColor(resources.getColor(R.color.berry, null))
                    text = formatNumber(Locale.getDefault(), averagePrice)
                }
            }
            showLoading.nonNullObserve(viewLifecycleOwner) {
                binding.spinner.isVisible = it
            }
            showError.nonNullObserve(viewLifecycleOwner) {
                with (binding.average) {
                    text = it
                    setTextColor(resources.getColor(R.color.red, null))
                }
            }
        }
    }
}