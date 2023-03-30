package com.example.awesome

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil

import com.example.awesome.placeholder.PlaceholderContent.PlaceholderItem
import com.example.awesome.databinding.FragmentItemBinding
import com.example.awesome.model.Sport

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class SportAdapter(private val onItemClicked: (Sport) -> Unit) :
    ListAdapter<Sport, SportAdapter.ViewHolder>(DiffCallback) {
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(item)
        }
        holder.bind(item, context)
    }


    inner class ViewHolder(private var binding: FragmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(sport: Sport, context: Context) {
            binding.newsTitle.text = context.getString(sport.titleResourceId)
            binding.subTitle.text = context.getString(sport.subTitleResourceId)
            binding.sportsImage.setImageResource(sport.imageResourceId)
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Sport>() {
            override fun areItemsTheSame(oldItem: Sport, newItem: Sport): Boolean {
                return (oldItem.id == newItem.id ||
                        oldItem.titleResourceId == newItem.titleResourceId ||
                        oldItem.subTitleResourceId == newItem.subTitleResourceId
                        )
            }

            override fun areContentsTheSame(oldItem: Sport, newItem: Sport): Boolean {
                return oldItem == newItem
            }
        }
    }
}