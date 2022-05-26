package com.nocompany.data.api.retrofit

import android.util.Log
import com.nocompany.domain.model.ResultState
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class NetworkResponseAdapter<T>(
    private val successType : Type
) :CallAdapter<T, Call<ResultState<T>>> {

    override fun responseType(): Type {
        return successType
    }

    override fun adapt(call: Call<T>): Call<ResultState<T>> {
        return NetworkResponse(call)
    }
}