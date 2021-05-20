package com.accubits.mvvm_starter.utils

import android.content.Context
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.text.TextUtils
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

object CommonUtils {

    public fun hasInternet(context: Context):Boolean{
        val connectivityManager = context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager

        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when{
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false

        }
    }

    fun isDeviceinDarkMode(context: Context):Boolean{
        var isDark = false
        val mode = context?.resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)
        when (mode) {
            Configuration.UI_MODE_NIGHT_YES -> {
                isDark = true
            }
            Configuration.UI_MODE_NIGHT_NO -> {}
            Configuration.UI_MODE_NIGHT_UNDEFINED -> {}
        }
        return isDark
    }

    /*
    * Methods to validate text from TextInput layout , Edittext
    * */


    fun validateField(
        textInputLayout: TextInputLayout, pattern: Pattern?, minLength: Int,
        errorMessage: String?
    ): Boolean {
        return try {
            val text =
                textInputLayout.editText!!.text.toString().trim { it <= ' ' }
            if (!TextUtils.isEmpty(text) &&
                (pattern == null || pattern.matcher(text).matches()) &&
                text.length >= minLength
            ) {
                textInputLayout.error = null
                return true
            }
            if (errorMessage != null) {
                textInputLayout.error = errorMessage
            }
            false
        } catch (e: Exception) {
            if (errorMessage != null) {
                textInputLayout.error = errorMessage
            }
            false
        }
    }

    fun validateField(
        editText: EditText, pattern: Pattern?, minLength: Int,
        errorMessage: String?
    ): Boolean {
        return try {
            val text =
                editText!!.text.toString().trim { it <= ' ' }
            if (!TextUtils.isEmpty(text) &&
                (pattern == null || pattern.matcher(text).matches()) &&
                text.length >= minLength
            ) {
                editText.error = null
                return true
            }
            if (errorMessage != null) {
                editText.error = errorMessage
            }
            false
        } catch (e: java.lang.Exception) {
            if (errorMessage != null) {
                editText.error = errorMessage
            }
            false
        }
    }
}