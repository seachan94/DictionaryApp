package com.nocompany.data.api.retrofit

import android.util.Log
import com.nocompany.domain.model.ResultState
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class NetworkResponseAdapterFactory : CallAdapter.Factory() {
    val TAG = "sechan"
    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit,
    ): CallAdapter<*, *>? {
        Log.d(TAG, "get: ")
        if(Call::class.java != getRawType(returnType)){
            return null
        }

        check(returnType is ParameterizedType)

        val responseType = getParameterUpperBound(0,returnType)
        if(getRawType(responseType)!=ResultState::class.java){
            return null
        }

        check(responseType is ParameterizedType)
        val successBodyType = getParameterUpperBound(0,responseType)
        return NetworkResponseAdapter<Any>(successBodyType)
    }
}