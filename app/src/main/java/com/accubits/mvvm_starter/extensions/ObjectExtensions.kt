package com.accubits.mvvm_starter.extensions

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

private const val TIME_STAMP_FORMAT = "EEEE, MMMM d, yyyy - hh:mm:ss a"
private const val DATE_FORMAT = "yyyy-MM-dd"

fun Long.getTimeStamp(): String {
    val date = Date(this)
    val simpleDateFormat = SimpleDateFormat(TIME_STAMP_FORMAT, Locale.getDefault())
    simpleDateFormat.timeZone = TimeZone.getDefault()
    return simpleDateFormat.format(date)
}

@Throws(ParseException::class)
fun String.getDateUnixTime(): Long {
    try {
        val simpleDateFormat = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        simpleDateFormat.timeZone = TimeZone.getDefault()
        return simpleDateFormat.parse(this)!!.time
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    throw ParseException("Please Enter a valid date", 0)
}

fun Any?.isNull() = this == null

fun Any.toJsonString():String{
    return Gson().toJson(this)
}

fun <T : Any> String.fromJson(destination:Class<T>): T {
    return Gson().fromJson(this,destination)
}
