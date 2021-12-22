package com.ashutosh1234ojha.unittestapp.others

/**
 * Created by Ashutosh Ojha on 29,October,2021
 */
data class Resource<out T>(val status: Status, val data: T?, val msg: String?) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String?, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?, msg: String?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }

}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}
