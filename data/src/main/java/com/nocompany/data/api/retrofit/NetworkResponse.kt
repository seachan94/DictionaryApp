package com.nocompany.data.api.retrofit

import android.util.Log
import com.nocompany.domain.model.ResultState
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

internal class NetworkResponse<T>(
    private val delegate : Call<T>
) :Call<ResultState<T>>{
    val TAG = "sechan"
    override fun enqueue(callback: Callback<ResultState<T>>) {
        return delegate.enqueue( object : Callback<T>{
            override fun onResponse(call: Call<T>, response: Response<T>) {
                response.body()?.let{
                    when(response.code()){
                        in 200..208 ->{
                            callback.onResponse(
                                this@NetworkResponse,
                                Response.success(ResultState.Success(it))
                            )
                        }
                        in  400..409 ->{
                            callback.onResponse(
                                this@NetworkResponse,
                                Response.success(ResultState.ApiError(response.code(),response.message()))
                            )
                        }
                    }
                }?:callback.onResponse(
                    this@NetworkResponse,
                    Response.success(ResultState.ApiError(response.code(),"BODY EMPTY"))
                )
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                callback.onResponse(
                    this@NetworkResponse,
                    Response.success(ResultState.NetworkError(t))
                )
                call.cancel()
            }

        })
    }

    override fun clone(): Call<ResultState<T>> =
        NetworkResponse(delegate.clone())

    override fun execute(): Response<ResultState<T>> =
        throw UnsupportedOperationException("ResponseCall does not support execute.")

    override fun isExecuted(): Boolean =
        delegate.isExecuted

    override fun cancel() =
        delegate.cancel()

    override fun isCanceled(): Boolean =
        delegate.isCanceled

    override fun request(): Request =
        delegate.request()

    override fun timeout(): Timeout =
        delegate.timeout()


}