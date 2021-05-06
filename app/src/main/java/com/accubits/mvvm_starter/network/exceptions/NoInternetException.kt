package com.accubits.mvvm_starter.network.exceptions

import java.io.IOException

class NoInternetException : IOException() {
    override val message: String?
        get() = "No Internet Connection"
}