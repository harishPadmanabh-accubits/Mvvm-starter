package com.accubits.mvvm_starter.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.accubits.mvvm_starter.R
import com.accubits.mvvm_starter.data.models.Category
import com.accubits.mvvm_starter.extensions.loadImageWithVeil
import kotlinx.android.synthetic.main.item_category.view.*

object CategoryDiffUtils : DiffUtil.ItemCallback<Category>(){
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.idCategory==newItem.idCategory
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.idCategory==newItem.idCategory &&
                oldItem.strCategory==newItem.strCategory &&
                oldItem.strCategoryThumb==newItem.strCategoryThumb
    }

}

class CategoryAdapter ():ListAdapter<Category,CategoryAdapter.ViewHolder>(CategoryDiffUtils) {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.apply {
            iv_category_image.loadImageWithVeil(item.strCategoryThumb,item_veilLayout)
            tv_category_title.text = item.strCategory
            tv_category_desc.text = item.strCategoryDescription
        }
    }
}