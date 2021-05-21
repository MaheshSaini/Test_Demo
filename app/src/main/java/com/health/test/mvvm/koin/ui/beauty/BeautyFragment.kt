package com.health.test.mvvm.koin.ui.beauty

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.base.BR
import com.base.BaseFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.health.test.R
import com.health.test.database.DbManager
import com.health.test.databinding.FragmentBeautyTipsBindingImpl
import com.health.test.mvvm.koin.adapter.AyurvedaTipsAdapter
import com.health.test.mvvm.koin.adapter.ItemClickListener
import com.health.test.mvvm.koin.model.TestDataResponse
import com.health.test.mvvm.koin.ui.details.DetailsActivity
import com.health.test.mvvm.koin.ui.home.HomeActivity
import com.health.test.utils.Constants.DESCRIPTION
import com.health.test.utils.Constants.TITLE
import com.health.test.utils.Utils
import kotlinx.android.synthetic.main.fragment_beauty_tips.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.w3c.dom.Text
import java.util.*

class BeautyFragment : BaseFragment<FragmentBeautyTipsBindingImpl, BeautyViewModel>(),
        BeautyNavigator {
    private val dailyTipsViewModel: BeautyViewModel by viewModel()
    private lateinit var mContext: HomeActivity
    private var recyclerViewShow: RecyclerView? = null
  //  var dbManager: DbManager? = null
    companion object {
        fun newInstance(bundle: Bundle): BeautyFragment {
            val args = Bundle()
            val fragment = BeautyFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun getViewModel(): BeautyViewModel = dailyTipsViewModel
    override fun getLayoutId(): Int = R.layout.fragment_beauty_tips
    override fun getBindingVariable(): Int = BR.viewModel
    override fun updateUI(savedInstanceState: Bundle?) {
        dailyTipsViewModel.setNavigator(this)
        setUIData()
    }

    private fun setUIData() {
        mContext.updateToolBarTitle("Test")
       /* DbManager.createInstance(mContext)
        getViewModel().dbManager = DbManager.getInstance()*/
        /* recyclerViewShow = view!!.findViewById<View>(R.id.recyclerViewShow) as RecyclerView
         mContext?.updateToolBarTitle(getString(R.string.health_book))
         recyclerViewShow?.setHasFixedSize(true)
         val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
         recyclerViewShow?.layoutManager = layoutManager*/

    }

/*    private fun showDataInList() {
        try {
            if (eBookDataResponses.size > 0) {
                Collections.sort(eBookDataResponses, SortByDateForHealth())
                Collections.reverse(eBookDataResponses)
                val adapter = EBookListRecyclerAdapter(activity!!, eBookDataResponses)
                recyclerViewShow!!.adapter = adapter
                adapter.setClickListener(this)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, getString(R.string.no_data_found_message), Toast.LENGTH_SHORT).show()
            }
        } catch (ee: Exception) {
            ee.printStackTrace()
        }
    }*/
    override fun hideProgress() {
        mContext.hideProgress()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = (context as HomeActivity)
    }


}
