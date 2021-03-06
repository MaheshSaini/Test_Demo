package com.base

import androidx.lifecycle.ViewModel
import com.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.lang.ref.WeakReference

/**
 * Mahesh Saini on 08:43 8/20/18
 */
abstract class BaseViewModel<N>(private var schedulerProvider: SchedulerProvider) : ViewModel() {
    private var repoManager: RepoManager? = null
    private lateinit var navigator: WeakReference<N>
    var compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun setNavigator(navigator: N) {
        this.navigator = WeakReference(navigator)
    }

    fun getNavigator(): N = navigator.get()!!

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun launch(job: () -> Disposable) {
        compositeDisposable.add(job())
    }

    fun dispose() {
        compositeDisposable.dispose()
    }

    fun clear() {
        compositeDisposable.clear()
    }
}