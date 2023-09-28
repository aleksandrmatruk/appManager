package com.matalex.appmanager

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.matalex.appmanager.databinding.ListItemBinding

class AppItemAdapter(private val context: Context, private val appItemList: MutableList<AppItem>) :
    RecyclerView.Adapter<AppItemAdapter.AppItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return AppItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppItemViewHolder, position: Int) {
        val appItem = appItemList[position]
        holder.bind(appItem)
    }

    override fun getItemCount(): Int {
        return appItemList.size
    }

    class AppItemViewHolder(foodItemLayoutBinding: ListItemBinding) :
        RecyclerView.ViewHolder(foodItemLayoutBinding.root) {

        private val binding = foodItemLayoutBinding

        fun bind(appItem: AppItem) {
            binding.appName.text = appItem.appName
            binding.appData.text = appItem.appDate
            binding.appPackage.text = appItem.appPackage
            binding.appIcon.setImageDrawable(appItem.appIcon)
        }

    }
}