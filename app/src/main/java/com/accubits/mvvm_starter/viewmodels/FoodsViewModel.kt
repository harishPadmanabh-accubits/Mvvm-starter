package com.accubits.mvvm_starter.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.accubits.mvvm_starter.data.repositories.FoodRepository

class FoodsViewModel (app:Application):AndroidViewModel(app){

    val repository = FoodRepository(app)
    fun getData() = repository.getCategories(viewModelScope)
    val events = repository.evetsData
    val categoriesData = repository.getCategoriesFromDb()


}