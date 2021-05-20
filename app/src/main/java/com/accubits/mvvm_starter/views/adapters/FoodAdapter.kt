package com.accubits.mvvm_starter.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.accubits.mvvm_starter.R
import com.accubits.mvvm_starter.data.models.Food
import com.accubits.mvvm_starter.extensions.loadImageWithUrl
import kotlinx.android.synthetic.main.item_food.view.*

class FoodAdapter(val foodList:List<Food>): RecyclerView.Adapter<FoodAdapter.ViewHolder> (){
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = foodList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = foodList[position]
        holder.itemView.apply {
            iv_food_thumbnail.loadImageWithUrl(item.strMealThumb)
            tv_food_title.text = item.strMeal
        }
    }
}