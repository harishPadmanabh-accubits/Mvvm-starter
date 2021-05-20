package com.accubits.mvvm_starter.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.accubits.mvvm_starter.R
import com.accubits.mvvm_starter.data.models.Category
import com.accubits.mvvm_starter.extensions.*
import com.accubits.mvvm_starter.viewmodels.AuthViewModel
import com.accubits.mvvm_starter.viewmodels.FoodsViewModel
import com.accubits.mvvm_starter.views.adapters.CategoryAdapter
import com.accubits.mvvm_starter.views.adapters.CategorySelectionListener
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import kotlinx.android.synthetic.main.activity_main.*

class HomeActivity : AppCompatActivity(),CategorySelectionListener {

    private  lateinit var viewModel: FoodsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        getCategories()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.apply {
            events.observe(this@HomeActivity, Observer {
                showLongToast(it)
            })
            categoriesData.observe(this@HomeActivity, Observer {
                setupRecyclerView(it)
            })
        }
    }

    private fun setupRecyclerView(categories: List<Category>?) {
        categories?.let {data->
            val adapter = CategoryAdapter(this).also {
                it.submitList(data)
            }
            recyclerView.adapter = adapter
            recyclerView.setItemTransformer(
                ScaleTransformer.Builder()
                    .setMaxScale(1.25f)
                    .setMinScale(0.8f)
                    .build()
            )
        }

    }

    private fun getCategories() {
        viewModel.getData()
    }

    private fun initViewModel() {
        viewModel = obtainViewModel(FoodsViewModel::class.java)
    }

    override fun onCategorySelected(item: Category) {
        openActivity(FoodListActivity::class.java){
            putString("selected_category",item.toJson())
        }
    }
}