package com.aplicacion.thesimpson.feature.presentation

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.aplicacion.thesimpson.R
import com.aplicacion.thesimpson.databinding.FragmentSimpsonDetailBinding
import com.aplicacion.thesimpson.feature.domain.Simpson

class SimpsonDetailFragment : Fragment() {

    private var _binding: FragmentSimpsonDetailBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val SIMPSON_KEY = "simpson_key"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSimpsonDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val simpson: Simpson? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable(SIMPSON_KEY, Simpson::class.java)
        } else {
            @Suppress("DEPRECATION")
            arguments?.getParcelable(SIMPSON_KEY)
        }

        if (simpson != null) {
            binding.nameDetail.text = simpson.name
            binding.occupationDetail.text = simpson.occupation
            binding.imgDetail.load(simpson.portraitPath) {
                crossfade(true)
                placeholder(R.drawable.ic_launcher_background)
                error(R.drawable.ic_launcher_foreground)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}