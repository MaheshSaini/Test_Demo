package com.health.test.mvvm.koin.ui.details

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.androidnetworking.model.Progress
import com.base.BR
import com.base.BaseActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.health.test.R
import com.health.test.databinding.ActivityShowDetailsBindingImpl
import com.health.test.mvvm.koin.model.TestDataResponse
import com.health.test.retrofit.ProgressDialogLoader
import com.health.test.utils.Utils
import com.utils.Logger
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class DetailsActivity : BaseActivity<ActivityShowDetailsBindingImpl, DetailsActivityViewModel>(),
        DetailsActivityNavigator {
    private val homeViewModel: DetailsActivityViewModel by viewModel()
    private var toolbar: Toolbar? = null
    private var ivTitle: ImageView? = null

    var progressBar: ProgressBar? = null


    companion object {
        val logger = Logger.getLogger(DetailsActivity::class.java)
    }

    override fun getLayoutId(): Int = R.layout.activity_show_details

    override fun getBindingVariable(): Int = BR.viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    private fun initUI() {
        ivTitle = findViewById<View>(R.id.ivTitle) as ImageView
        progressBar = findViewById<View>(R.id.progressBar) as ProgressBar

        if (Utils.checkInternetConnection(Objects.requireNonNull(this))) {
            //showProgress()
            progressBar?.visibility = View.VISIBLE
            getViewModel().getDataFromServer()
        } else {
            Toast.makeText(this, getString(R.string.check_internet), Toast.LENGTH_LONG).show()

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.share_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.share_story -> {

                true
            }
            else ->                 // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                super.onOptionsItemSelected(item)
        }
    }


    override fun updateUI(savedInstanceState: Bundle?) {
        homeViewModel.setNavigator(this)
        toolbar?.let {
            setUpToolBar(it.id, true)
        }
        initUI()
    }

    override fun getViewModel(): DetailsActivityViewModel = homeViewModel


    private fun updateToolBarTitle(title: String) {
        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar?.let {
            it.title = title
        }
        supportActionBar?.title = title
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
            toolbar?.setNavigationOnClickListener {
                // displayInterstitial()
                finish()
            }
        }

    }

    override fun hideProgress() {
        ProgressDialogLoader.progressdialogDismiss()
    }

    fun showProgress() {
        ProgressDialogLoader.progressDialogCreation(this, getString(R.string.loading))
    }

    override fun setData(testDataResponse1: TestDataResponse) {
        //hideProgress()
        progressBar?.visibility = View.GONE
        Glide.with(this)
                .load(testDataResponse1.data?.avatar)//"https://reqres.in/img/faces/2-image.jpg"
                .apply(RequestOptions().circleCrop()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true))
                .into(ivTitle!!)
    }

}
