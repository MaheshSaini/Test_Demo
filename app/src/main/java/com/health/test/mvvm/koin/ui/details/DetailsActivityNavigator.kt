package com.health.test.mvvm.koin.ui.details

import com.health.test.mvvm.koin.model.TestDataResponse

/**
 * Mahesh Saini on 10:15 2018-12-19
 */
interface DetailsActivityNavigator {
    fun hideProgress()
    //fun hideProgress1()
    fun setData(testDataResponse1: TestDataResponse)
}