package com.aplicacion.thesimpson.feature.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.aplicacion.thesimpson.R
import com.aplicacion.thesimpson.core.error.ErrorApp
import com.aplicacion.thesimpson.databinding.FragmentListSimpsonBinding
import com.aplicacion.thesimpson.feature.presentation.adapter.SimpsonAdapter
import com.aplicacion.thesimpson.feature.simpson.presentation.SimpsonViewModelFactory
import kotlinx.coroutines.launch

class SimpsonListFragment : Fragment() {

    private var _binding: FragmentListSimpsonBinding? = null
    private val binding get() = _binding!!

    private lateinit var simpsonAdapter: SimpsonAdapter

    private val viewModel: SimpsonViewModel by viewModels { SimpsonViewModelFactory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListSimpsonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeUiState()
    }

    private fun setupRecyclerView() {
        simpsonAdapter = SimpsonAdapter { simpson ->

            val bundle = bundleOf(SimpsonDetailFragment.SIMPSON_KEY to simpson)

            findNavController().navigate(
                R.id.action_simpsonListFragment_to_simpsonDetailFragment,
                bundle
            )
        }
        binding.rvSimpsons.adapter = simpsonAdapter
    }

    private fun observeUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    binding.rvSimpsons.isVisible = !state.isLoading
                    simpsonAdapter.submitList(state.simpsons)
                    state.error?.let { error ->
                        val message = when (error) {
                            is ErrorApp.NetworkError -> "Error de red"
                            is ErrorApp.NotFoundError -> "No se encontraron personajes"
                            else -> "Error desconocido"
                        }
                        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}