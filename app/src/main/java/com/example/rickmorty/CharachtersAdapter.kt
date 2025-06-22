package com.example.rickmorty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickmorty.databinding.CharacterItemBinding

class CharachtersAdapter(val characters: List<CharacterDto>) : RecyclerView.Adapter<CharachtersAdapter.CharViewHolder>() {

    class CharViewHolder(private val binding: CharacterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: CharacterDto) {
            binding.characterName.text = character.fullName
            binding.lifeStatusTv.text = character.lifeStatus
            binding.placeOfOriginTv.text = character.placeOfOrigin.originName
        }
    }

    //Crear el viewholder
    //viewType: indica el tipo de vista, nos puede ayudar a cambiar el tipo de diseño del viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharViewHolder {
        val view = CharacterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharViewHolder(view)
    }

    //Cantidad de elementos
    override fun getItemCount(): Int {
        return characters.size
    }

    //Asignar los datos a los elementos
    override fun onBindViewHolder(holder: CharViewHolder, position: Int) {
        holder.bind(characters[position])
    }
}