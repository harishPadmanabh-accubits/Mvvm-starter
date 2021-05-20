package com.accubits.mvvm_starter.data.repositories

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.accubits.mvvm_starter.data.db.AppDatabase
import com.accubits.mvvm_starter.data.models.Category
import com.accubits.mvvm_starter.data.network.ApiManger
import com.accubits.mvvm_starter.extensions.doLogWithTag
import com.skydoves.sandwich.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FoodRepository(val context: Application) {

    val api = ApiManger(context).api
    val database = AppDatabase.getDatabase(context)
    val foodDao = database.getFoodDao()
    val evetsData = MutableLiveData<String>()


    fun getCategories(scope: CoroutineScope) {
        scope.launch(Dispatchers.IO) {
            api.getCategories().request { res ->
                res.onSuccess {
                    val categories = this.data?.categories
                    insertCategories(categories, scope)
                }.onError {
                    doLogWithTag("API ERROR", this.message())
                    evetsData.value = this.message()


                }.onException {
                    doLogWithTag("API ERROR", this.message())
                    evetsData.value = this.exception.message
                }

            }


        }
    }

    private fun insertCategories(categories: List<Category>?, scope: CoroutineScope) {
        scope.launch(Dispatchers.IO) {
            categories?.forEach {
                foodDao.insertCategory(it)
            }
        }
    }

    fun getCategoriesFromDb() = foodDao.getCategories()


}