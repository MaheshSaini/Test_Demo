package com.health.test.mvvm.koin.api

import com.health.test.mvvm.koin.model.TestDataResponse
import io.reactivex.Single
import retrofit2.http.GET

interface AppXPlusNetworkApis {
    @GET("/api/users/2")
    fun getDataFromServer(): Single<TestDataResponse>


}