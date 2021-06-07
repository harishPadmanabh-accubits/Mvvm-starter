package com.accubits.mvvm_starter.data.network.generics

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.Callback


/**
 * A generic class that holds a value with its loading status.
 */
class Resource<T> {

    val data: T?
    val throwable: Throwable?
    val call: Call<T>?
    val callback: Callback<T>?
    var status: APIClientStatus.Status
    val errorResponse: ErrorResponse?

    constructor(
        status: APIClientStatus.Status,
        data: T?,
        call: Call<T>?,
        callback: Callback<T>?,
        errorResponse: ErrorResponse?
    ) {
        this.status = status
        this.data = data
        this.throwable = null
        this.call = call
        this.callback = callback
        this.errorResponse = errorResponse
    }

    constructor(
        status: APIClientStatus.Status,
        data: T?,
        throwable: Throwable?,
        call: Call<T>?,
        callback: Callback<T>?,
        errorResponse: ErrorResponse?
    ) {
        this.status = status
        this.data = data
        this.throwable = throwable
        this.call = call
        this.callback = callback
        this.errorResponse = errorResponse
    }

    override fun hashCode(): Int {
        var result = status.hashCode()
        result = 31 * result + (data?.hashCode() ?: 0)
        return result
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) {
            return true
        }
        if (o == null || javaClass != o.javaClass) {
            return false
        }
        return false
    }

    override fun toString(): String {
        return ("Resource{"
                + "status="
                + status
                + ", data="
                + data
                + '}'.toString())
    }

    companion object {

        fun <T> success(data: T?): Resource<T> {
            return Resource(APIClientStatus.Status.SUCCESS, data, null, null, null)
        }

        fun <T> error(
            msg: String, data: T?, callback: Call<T>?,
            errorResponse: ErrorResponse?
        ): Resource<T> {
            return Resource(APIClientStatus.Status.ERROR, data, callback, null, errorResponse)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(APIClientStatus.Status.LOADING, data, null, null, null)
        }
    }
}


/**
 * Class used for loading different status of Retrofit call
 */

class APIClientStatus {
    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }
}



/**
 * Class containing error response for the APIs.
 */
data class ErrorResponse(

    @SerializedName("Message")
    @Expose
    public var error: String? = null,
    @SerializedName("Description")
    @Expose
    var description: String? = null,
    @SerializedName("ErrorCode")
    var errorCode: Int = -1

) {
    /**
     * function to get error message from the server
     */
    fun getErrorMessage(): String? {
        val message: String? =
            if (!error.isNullOrEmpty()) {
                error
            } else if (!description.isNullOrEmpty()) {
                description
            } else {
                null
            }
        return message
    }
}
