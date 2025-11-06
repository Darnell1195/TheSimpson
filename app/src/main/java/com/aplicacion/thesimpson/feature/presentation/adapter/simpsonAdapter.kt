package com.aplicacion.thesimpson.feature.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aplicacion.thesimpson.R
import com.aplicacion.thesimpson.databinding.ItemSimpsonBinding
import com.aplicacion.thesimpson.feature.domain.Simpson
import com.aplicacion.thesimpson.feature.presentation.SimpsonDiffCallback

class SimpsonAdapter(
    private val onItemClicked: (Simpson) -> Unit
) : ListAdapter<Simpson, SimpsonAdapter.SimpsonViewHolder>(SimpsonDiffCallback()) {

    inner class SimpsonViewHolder(private val binding: ItemSimpsonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(simpson: Simpson) {
            binding.Name.text = simpson.name
            binding.Occupation.text = simpson.occupation

            binding.img.load(simpson.portraitPath) {
                crossfade(true)
                placeholder(R.drawable.ic_launcher_background)
                error(R.drawable.ic_launcher_foreground)
            }

            binding.root.setOnClickListener { onItemClicked(simpson) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpsonViewHolder {
        val binding = ItemSimpsonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SimpsonViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SimpsonViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
