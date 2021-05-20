package com.accubits.mvvm_starter.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.accubits.mvvm_starter.R
import com.accubits.mvvm_starter.data.models.Category
import com.accubits.mvvm_starter.data.models.Food
import com.accubits.mvvm_starter.extensions.fromJson
import com.accubits.mvvm_starter.extensions.obtainViewModel
import com.accubits.mvvm_starter.viewmodels.FoodsViewModel
import com.accubits.mvvm_starter.views.adapters.FoodAdapter
import kotlinx.android.synthetic.main.activity_food_list.*

class FoodListActivity : AppCompatActivity() {

    private lateinit var viewModel: FoodsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_list)
        viewModel = obtainViewModel(FoodsViewModel::class.java)
        getSelectedCategory()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.apply {
            getFoodsByCategory()
            foodsData.observe(this@FoodListActivity, androidx.lifecycle.Observer { foodList->
                setupRecyclerView(foodList)
            })
        }
    }

    private fun setupRecyclerView(foodList: List<Food>) {
        rv_food_list.layoutManager = StaggeredGridLayoutManager(2,RecyclerView.VERTICAL)
        rv_food_list.adapter = FoodAdapter(foodList)
    }

    private fun getSelectedCategory() {
        viewModel.selectedCategory =
            intent.getStringExtra("selected_category")?.fromJson(Category::class.java)
    }
}