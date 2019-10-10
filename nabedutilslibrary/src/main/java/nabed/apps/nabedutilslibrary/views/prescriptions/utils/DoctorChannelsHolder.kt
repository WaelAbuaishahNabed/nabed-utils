package nabed.apps.nabedutilslibrary.views.prescriptions.utils

import android.content.Context
import android.content.res.Resources
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import nabed.apps.nabedutilslibrary.R
import nabed.apps.service.models.DoctorContent
import nabed.apps.service.models.Feed


open class DoctorChannelsHolder(view: View, clickListener: View.OnClickListener?) : RecyclerView.ViewHolder(view) {
    private var channelsTitle: TextView? = null
    private var mainCell: View? = null
    private var image:ImageView?=null
    private var recyclerView: RecyclerView? = null
    private var videoCount:TextView?=null
    private var date:TextView?=null
    private var isNew:View?=null
    private val DP = Resources.getSystem().displayMetrics.density
    private var requestOptions = RequestOptions()

    init {
        findViews(itemView)
        mainCell?.setOnClickListener(clickListener)
    }

    private fun findViews(itemView: View) {
        this.channelsTitle = itemView.findViewById(R.id.txt_channelsTitle)

        this.mainCell = itemView.findViewById(R.id.mainCell)
        this.recyclerView = itemView.findViewById(R.id.listOfFeedsRecyclerView)
        this.image=itemView.findViewById(R.id.image_channels)
        this.videoCount=itemView.findViewById(R.id.countText)
        this.date=itemView.findViewById(R.id.date)
        this.isNew=itemView.findViewById(R.id.isNew)
    }

    open fun onBind(_context: Context,
                    channelsModel: Feed,
                    postion: Int,
                    doctorContent: DoctorContent
    ) = with(itemView) {

        if (channelsModel != null) {
            mainCell?.setTag(R.string.item_tag, channelsModel)
            channelsTitle?.text = channelsModel!!.title
            requestOptions.placeholder(R.drawable.image_place_holder_rectangle)
            requestOptions.error(R.drawable.image_place_holder_rectangle)
            val radius = ((6 * DP).toInt())
            requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(radius))
            if (channelsModel!!.media != null && channelsModel!!.media?.images != null && !channelsModel!!.media?.images?.isEmpty()!!) {
                Glide.with(context).load(channelsModel!!.media!!.images!![0].url).apply(requestOptions).into(image!!)
            } else if (channelsModel!!.media != null && channelsModel!!.media?.videos != null && !channelsModel!!.media?.videos?.isEmpty()!!) {
                Glide.with(context).load(channelsModel!!.media!!.videos!![0].thumbnailUrl).apply(requestOptions).into(image!!)
            }
            if(channelsModel.contentCountValue is String) {
                videoCount?.text = channelsModel.contentCountValue.toString() + " " + context.getString(R.string.video)
            }
            date?.text=channelsModel!!.categoryHealthCenter?.title

            if (channelsModel?.type != null &&
                    channelsModel.type == "broadcast") {
                isNew?.visibility = View.GONE
            } else {
                if(channelsModel.total_unread_count!=null&&channelsModel.total_unread_count!!.toInt()>0){
                    isNew?.visibility=View.VISIBLE
                }else{
                    isNew?.visibility=View.INVISIBLE
                }
            }
        }
    }
}
