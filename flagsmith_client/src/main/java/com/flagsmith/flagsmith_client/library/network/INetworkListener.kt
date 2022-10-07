package com.flag.android.network

interface INetworkListener {
    fun success(response: String?)
    fun failed(error: String?)
}