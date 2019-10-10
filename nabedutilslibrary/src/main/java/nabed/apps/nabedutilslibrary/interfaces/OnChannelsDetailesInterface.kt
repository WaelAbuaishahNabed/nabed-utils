package nabed.apps.nabedutilslibrary.interfaces

import nabed.apps.service.models.Feed

interface OnChannelsDetailesInterface {
    fun onAction(channelsModel: Feed)
    fun onSelfSelect()
}