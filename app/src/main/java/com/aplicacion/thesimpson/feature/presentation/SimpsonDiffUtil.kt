package com.aplicacion.thesimpson.feature.presentation

import androidx.recyclerview.widget.DiffUtil
import com.aplicacion.thesimpson.feature.domain.Simpson


class SimpsonDiffCallback : DiffUtil.ItemCallback<Simpson>() {
    override fun areItemsTheSame(oldItem: Simpson, newItem: Simpson): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Simpson, newItem: Simpson): Boolean {
        return oldItem == newItem
    }
}
