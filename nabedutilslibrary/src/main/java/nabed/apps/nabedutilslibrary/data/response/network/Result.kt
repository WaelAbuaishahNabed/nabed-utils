package nabed.apps.nabedutilslibrary.data.response.network

import java.lang.Exception


sealed class Result<out T : Any>{
    data class success<out T : Any>(val data : T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}