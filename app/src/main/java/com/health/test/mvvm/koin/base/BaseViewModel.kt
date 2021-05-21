package com.health.test.mvvm.koin.base

import com.base.BaseViewModel
import com.health.test.mvvm.koin.data.DataManager
import com.utils.SchedulerProvider

/**
 * Mahesh Saini on 10:15 2018-12-19
 */
open class BaseViewModel<N>(var dataManager: DataManager, var schedulerProvider: SchedulerProvider) :
        BaseViewModel<N>(schedulerProvider) {

}

