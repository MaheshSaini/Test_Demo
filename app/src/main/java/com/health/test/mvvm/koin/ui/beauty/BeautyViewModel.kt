package com.health.test.mvvm.koin.ui.beauty

import androidx.databinding.ObservableField
import com.health.test.mvvm.koin.api.AppXPlusNetworkApis
import com.health.test.mvvm.koin.base.BaseViewModel
import com.health.test.mvvm.koin.data.DataManager
import com.health.test.mvvm.koin.model.TestDataResponse
import com.health.test.mvvm.koin.api.ApiClient
import com.utils.SchedulerProvider
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.create
import java.lang.Exception


class BeautyViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider)
    : BaseViewModel<BeautyNavigator>(dataManager, schedulerProvider) {
    //var dbManager: DbManager? = null
 /*   fun addData() {
        try {
            getNavigator().showProgress()
            dbManager!!.open()
            val cur = dbManager!!.selectQuery("select * from  " + Constants.tbl_ayurveda + "")
            if (cur.count > 0) while (!cur.isAfterLast) {
                val ayurvedaTipsResponse = AyurvedaTipsResponse()
                ayurvedaTipsResponse.storyTitle = cur.getString(1)
                ayurvedaTipsResponse.storyDescription = cur.getString(2)
                arrayListAyurvedaTips.add(ayurvedaTipsResponse)
                cur.moveToNext()
            }
            cur.close()
            dbManager!!.close()
            getNavigator().hideProgress()
        } catch (e: Exception) {
            getNavigator().hideProgress()
            e.printStackTrace()
        }
    }*/


}