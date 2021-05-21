package com.health.test.mvvm.koin.ui.details

import androidx.databinding.ObservableField
import com.health.test.mvvm.koin.api.AppXPlusNetworkApis
import com.health.test.mvvm.koin.data.DataManager
import com.health.test.mvvm.koin.base.BaseViewModel
import com.health.test.mvvm.koin.model.TestDataResponse
import com.health.test.mvvm.koin.api.ApiClient
import com.utils.SchedulerProvider
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.create

/**
 * Mahesh Saini on 10:13 2018-12-19
 */
class DetailsActivityViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
        BaseViewModel<DetailsActivityNavigator>(dataManager, schedulerProvider) {
    var apiService: AppXPlusNetworkApis = ApiClient.getClientMVVMBaseUrl().create<AppXPlusNetworkApis>()
    var testDataResponse: TestDataResponse? = null
    var testDataResponseField: ObservableField<TestDataResponse> = ObservableField()
    //var name: ObservableField<String> = ObservableField("Mahesh Saini")

    fun getDataFromServer() {
        val genderResponse = apiService.getDataFromServer()
        genderResponse.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<TestDataResponse> {
                    override fun onSuccess(testDataResponse1: TestDataResponse) {
                        if (testDataResponse1 != null) {
                            testDataResponse = testDataResponse1
                            //name.set(testDataResponse1.data?.firstName)
                            getNavigator().setData(testDataResponse!!)
                            testDataResponseField.set(testDataResponse)
                            testDataResponseField.notifyChange()
                            //name.notifyChange(BR.viewModel.na)
                        }
                    }

                    override fun onSubscribe(d: Disposable) {
                        getNavigator().hideProgress()
                    }

                    override fun onError(e: Throwable) {
                        getNavigator().hideProgress()
                        e.printStackTrace()
                    }
                })
    }


}