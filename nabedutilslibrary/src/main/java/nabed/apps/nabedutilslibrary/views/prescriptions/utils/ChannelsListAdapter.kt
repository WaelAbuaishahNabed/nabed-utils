package nabed.apps.nabedutilslibrary.views.prescriptions.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nabed.apps.nabedutilslibrary.R
import nabed.apps.nabedutilslibrary.interfaces.OnChannelsDetailesInterface
import nabed.apps.nabedutilslibrary.utils.Constants
import nabed.apps.service.models.DoctorContent
import nabed.apps.service.models.Feed

class ChannelsListAdapter(
    private val items: ArrayList<Feed>,
    private val context: Context,
    private val onActionInterface: OnChannelsDetailesInterface,
    private var doctorContent: DoctorContent
) : RecyclerView.Adapter<DoctorChannelsHolder>() {


    private val clickListener: View.OnClickListener?
    private var screenType: Int = 0

    init {
        clickListener = View.OnClickListener { view ->
            run {
                if (view.id == R.id.mainCell) {
                    val _prescriptionsModel = view.getTag(R.string.item_tag) as Feed
                    onActionInterface!!.onAction(_prescriptionsModel)
                }
//                if (view.id == R.id.txt_seeAll) {
//                    val _prescriptionsModel = view.getTag(R.string.item_tag) as Feed
//                    onActionInterface!!.onAction(_prescriptionsModel)
//                }
//                if (view.id == R.id.root) {
//                    onActionInterface!!.onSelfSelect()
//                }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): DoctorChannelsHolder {
        val inflater = LayoutInflater.from(p0.context)
        val view: View
        val holder: DoctorChannelsHolder

        when (viewType) {

            Constants.TYPE_LIST_ITEM -> {
                view = inflater.inflate(R.layout.cell_channels_doctor2, p0, false)
                holder = DoctorChannelsHolder(view, clickListener)
            }

            else -> {
                view = inflater.inflate(R.layout.cell_channels_doctor2, p0, false)
                holder = DoctorChannelsHolder(view, clickListener)
            }
        }
        return holder
    }

    override fun getItemViewType(position: Int): Int {
        return if (items.size > 0) {
            if (items[position].id?.toInt() == -123) {
                Constants.TYPE_SELF_SELECT
            } else {
                Constants.TYPE_LIST_ITEM
            }
        } else {
            Constants.TYPE_NO_ITEM
        }
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(p0: DoctorChannelsHolder, position: Int) {
        var viewType: Int? = null
        viewType = if (items.size > 0) {
            getItemViewType(position)
        } else {
            Constants.TYPE_NO_ITEM
        }

        when (viewType) {

            Constants.TYPE_LIST_ITEM -> {
                p0.onBind(context, items[position], position, doctorContent = doctorContent)
            }

            else -> {

            }
        }

    }

    fun claerIsNew() {
        for (i in 0 until items.size) {
            items[i].total_unread_count = "0"
            this.notifyItemChanged(i)
        }
    }
}

