package com.health.test.mvvm.koin.ui.home

import androidx.fragment.app.Fragment

/**
 * Mahesh Saini on 10:15 2018-12-19
 */
interface HomeNavigator {
    fun replaceFragment(fragment: Fragment)
    fun hideProgress()
}