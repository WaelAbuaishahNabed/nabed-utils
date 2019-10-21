package nabed.apps.nabedutilslibrary.ui.prescriptions.utils


//class FeedSelfSelectHolder(view: View, clickListener: View.OnClickListener?) : DoctorChannelsHolder(view, clickListener) {
//    var selfSelectView:View?= null
//    var countText:TextView?=null
//    init {
//        findViews(itemView)
//        selfSelectView?.setOnClickListener(clickListener)
//    }
//
//    private fun findViews(itemView: View) {
//        this.selfSelectView = itemView.findViewById(R.id.root)
//        this.countText=itemView.findViewById(R.id.countText)
//
//    }
//
//    override fun onBind(_context: Context, channelsModel: Feed, postion: Int, doctorContent: DoctorContent) {
//        super.onBind(_context, channelsModel, postion,doctorContent)
//        selfSelectView?.setTag(R.string.item_tag, channelsModel)
//        if (doctorContent?.poc?.self_enrollment_count != null && doctorContent?.poc!!.self_enrollment_count!! > 0) {
//            val selectionMsg = String.format(getSelfSelectionSubjectContErrorTxt(doctorContent?.poc?.self_enrollment_count!!) , doctorContent?.poc?.self_enrollment_count)
//            countText?.text = selectionMsg
//        } else {
//            selfSelectView?.visibility = View.GONE
//        }
//
//    }
//}
