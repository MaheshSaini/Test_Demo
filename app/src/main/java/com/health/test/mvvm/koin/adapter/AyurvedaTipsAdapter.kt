package com.health.test.mvvm.koin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.health.test.R
import com.health.test.mvvm.koin.model.AyurvedaTipsResponse

class AyurvedaTipsAdapter(context: Context, listItems: ArrayList<AyurvedaTipsResponse>?) : RecyclerView.Adapter<AyurvedaTipsAdapter.MyViewHolder?>() {
    private var listItems: ArrayList<AyurvedaTipsResponse>?
    var mContext: Context
    private var clickListener: ItemClickListener? = null
    var viewHolder: MyViewHolder? = null
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.custome_layout_ayurveda, null)
        viewHolder = MyViewHolder(view)
        return viewHolder as MyViewHolder
    }

    override fun onBindViewHolder(customViewHolder: MyViewHolder, position: Int) {
        val trueStoryDataResponse: AyurvedaTipsResponse = listItems!![position]
        customViewHolder!!.txtTitle.setText(trueStoryDataResponse.storyTitle)
        customViewHolder.txtTitle.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation))
        customViewHolder.clDisplayText.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation))
        Glide.with(mContext)
                .load(R.drawable.ic_yoga)
                .apply(RequestOptions().circleCrop()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true))
                .into(customViewHolder.ivTitle)
    }

    fun addData(popularSpecialtiyList: ArrayList<AyurvedaTipsResponse>?) {
//        this.listItems.clear();
        listItems = popularSpecialtiyList
    }

    override fun getItemCount(): Int {
        return if (null != listItems) listItems!!.size else 0
    }

    fun setClickListener(itemClickListener: ItemClickListener?) {
        clickListener = itemClickListener
    }

    // initializes some private fields to be used by RecyclerView.
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        val clDisplayText: RelativeLayout
        val txtTitle: TextView
        val ivTitle: ImageView
        override fun onClick(view: View) {
            if (clickListener != null) clickListener?.onClick(view, adapterPosition)
        }

        init {
            ivTitle = itemView.findViewById(R.id.ivTitle)
            txtTitle = itemView.findViewById(R.id.txtTitle)
            clDisplayText = itemView.findViewById(R.id.clDisplayText)
            clDisplayText.setOnClickListener(this)
            itemView.tag = itemView
            clDisplayText.setOnClickListener(this)
        }
    }

    init {
        this.listItems = listItems
        mContext = context
    }


}
