package com.health.test.mvvm.koin.ui.home

import com.health.test.mvvm.koin.data.DataManager
import com.health.test.mvvm.koin.base.BaseViewModel
import com.utils.SchedulerProvider

/**
 * Mahesh Saini on 10:13 2018-12-19
 */
class HomeViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
        BaseViewModel<HomeNavigator>(dataManager, schedulerProvider) {
}

